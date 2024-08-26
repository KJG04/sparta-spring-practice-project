package com.sparta.spartaspringpracticeproject.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.spartaspringpracticeproject.config.JwtUtil;
import com.sparta.spartaspringpracticeproject.dto.ErrorResponseDto;
import com.sparta.spartaspringpracticeproject.entity.User;
import com.sparta.spartaspringpracticeproject.repository.UserRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Component
@Order(1)
public class AuthFilter implements Filter {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String url = httpServletRequest.getRequestURI();
        try {
            if (!StringUtils.hasText(url)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "잘못된 요청입니다.");
            }

            // 유저 생성, 로그인 시에는 토큰을 검증하지 않음
            if (httpServletRequest.getMethod().equals(HttpMethod.POST.name()) && (url.startsWith("/api/users") || url.startsWith("/api/users/login"))) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            String accessToken = httpServletRequest.getHeader(JwtUtil.AUTHORIZATION_HEADER);
            if (!StringUtils.hasText(accessToken)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "accessToken이 비어있습니다.");
            }

            if (!jwtUtil.validateToken(accessToken)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "유효하지 않은 accessToken입니다.");
            }

            Claims body = jwtUtil.getUserInfoFromToken(accessToken);
            Long userId = Long.valueOf(body.getSubject());

            User user = userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "유효하지 않은 accessToken입니다."));

            servletRequest.setAttribute("user", user);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ResponseStatusException e) {
            System.out.println(e.getReason());
            HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
            ErrorResponseDto errorResponseDto = ErrorResponseDto
                    .builder()
                    .timestamp(OffsetDateTime.now().withOffsetSameInstant(ZoneOffset.UTC).toString())
                    .status(e.getStatusCode().value())
                    .error(((HttpStatus) e.getStatusCode()).getReasonPhrase())
                    .message(e.getReason())
                    .path(url)
                    .build();

            String json = new ObjectMapper().writeValueAsString(errorResponseDto);
            httpServletResponse.setStatus(e.getStatusCode().value());
            httpServletResponse.setHeader("Content-Type", "application/json");
            httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
            httpServletResponse.getWriter().print(json);
        }
    }
}