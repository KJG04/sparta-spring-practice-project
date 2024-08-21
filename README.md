# API

| 기능       | Method | URL                | request                                                          | response             | 상태 코드 |
|----------|--------|--------------------|------------------------------------------------------------------|----------------------|-------|
| 일정 생성    | POST   | /api/todos         | body: { "title": string, "content": string, "userName": string } | TodoResponseDto      | 201   |
| 특정 일정 조회 | GET    | /api/todos/{id}    | no content                                                       | TodoResponseDto      | 200   |
| 특정 일정 수정 | PATCH  | /api/todos/{id}    | body: { "title": string, "content": string, "userName": string } | TodoResponseDto      | 200   |
| 댓글 생성    | POST   | /api/comments      | body: { "content": string, "userName": string }                  | CommentResponseDto   | 201   |
| 댓글 조회    | GET    | /api/comments      | no content                                                       | CommentResponseDto[] | 200   |
| 특정 댓글 조회 | GET    | /api/comments/{id} | no content                                                       | CommentResponseDto   | 200   |
| 특정 댓글 수정 | PATCH  | /api/comments/{id} | body: { "content": string, "userName": string }                  | CommentResponseDto   | 200   |
| 특정 댓글 삭제 | DELETE | /api/comments/{id} | no content                                                       | no content           | 204   |

# TodoResponseDto

```json
{
  "id": number,
  "title": string,
  "content": string,
  "userName": string,
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