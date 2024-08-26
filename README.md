# API

# 일정 API

| 기능       | Method | URL             | request                                                           | response                                           | 상태 코드 |
|----------|--------|-----------------|-------------------------------------------------------------------|----------------------------------------------------|-------|
| 일정 생성    | POST   | /api/todos      | body: { "title": string, "content": string, "userId": number }    | TodoResponseDto                                    | 201   |
| 일정 조회    | GET    | /api/todos      | query param: { "page": number = 0, "size": number = 10 }          | PageResponseDto\<TodoWithCommentCountResponseDto\> | 200   |
| 특정 일정 조회 | GET    | /api/todos/{id} | no content                                                        | TodoResponseDto                                    | 200   |
| 특정 일정 수정 | PATCH  | /api/todos/{id} | body: { "title"?: string, "content"?: string, "userId"?: number } | TodoResponseDto                                    | 200   |
| 특정 일정 삭제 | DELETE | /api/todos/{id} | no content                                                        | no content                                         | 204   |

# 댓글 API

| 기능       | Method | URL                | request                                                           | response             | 상태 코드 |
|----------|--------|--------------------|-------------------------------------------------------------------|----------------------|-------|
| 댓글 생성    | POST   | /api/comments      | body: { "content": string, "userName": string, "todoId": number } | CommentResponseDto   | 201   |
| 댓글 조회    | GET    | /api/comments      | no content                                                        | CommentResponseDto[] | 200   |
| 특정 댓글 조회 | GET    | /api/comments/{id} | no content                                                        | CommentResponseDto   | 200   |
| 특정 댓글 수정 | PATCH  | /api/comments/{id} | body: { "content"?: string, "userName"?: string }                 | CommentResponseDto   | 200   |
| 특정 댓글 삭제 | DELETE | /api/comments/{id} | no content                                                        | no content           | 204   |

# 유저 API

| 기능       | Method | URL              | request                                                       | response            | 상태 코드 |
|----------|--------|------------------|---------------------------------------------------------------|---------------------|-------|
| 유저 생성    | POST   | /api/users       | body: { "name": string, "email": string, "password": string } | AuthUserResponseDto | 201   |
| 유저 로그인   | POST   | /api/users/login | body: { "email": string, "password": string }                 | AuthUserResponseDto | 200   |
| 유저 조회    | GET    | /api/users       | no content                                                    | UserResponseDto[]   | 200   |
| 특정 유저 조회 | GET    | /api/users/{id}  | no content                                                    | UserResponseDto     | 200   |
| 특정 유저 수정 | PATCH  | /api/users/{id}  | body: { "content": string, "userName": string }               | UserResponseDto     | 200   |
| 특정 유저 삭제 | DELETE | /api/users/{id}  | no content                                                    | no content          | 204   |

# TodoResponseDto

```json
{
  "id": number,
  "title": string,
  "content": string,
  "user": UserResponseDto,
  "createAt": DateTime,
  "updateAt": DateTime
}
```

# CommentResponseDto

```json
{
  "id": number,
  "content": string,
  "userName": string,
  "createAt": DateTime,
  "updateAt": DateTime,
  "todo": TodoResponseDto
}
```

# PageResponseDto<T>

```json
{
  "totalPages": number,
  "totalElements": number,
  "first": boolean,
  "last": boolean,
  "size": number,
  "numberOfElements": number,
  "empty": boolean
  "content": T[],
}
```

# TodoWithCommentCountResponseDto

```json
{
  "id": number,
  "title": string,
  "content": string,
  "commentCount": number,
  "createAt": DateTime,
  "updateAt": DateTime
}
```

# UserResponseDto

```json
{
  "id": number,
  "name": string,
  "email": string,
  "createAt": DateTime,
  "updateAt": DateTime
}
```

# AuthUserResponseDto

```json
{
  "accessToken": string,
  "user": UserResponseDto
}
```