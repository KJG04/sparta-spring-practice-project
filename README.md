# API

| 기능       | Method | URL             | request                                                          | response                                                                                                             | 상태 코드 |
|----------|--------|-----------------|------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|-------|
| 일정 저장    | POST   | /api/todos      | body: { "title": string, "content": string, "userName": string } | { "id": number, "title": string, "content": string, "userName": string, "createAt": DateTime, "updateAt": DateTime } | 201   |
| 특정 일정 조회 | POST   | /api/todos/{id} | no content                                                       | { "id": number, "title": string, "content": string, "userName": string, "createAt": DateTime, "updateAt": DateTime } | 200   |
| 특정 일정 수정 | PUT    | /api/todos/{id} | body: { "title": string, "content": string, "userName": string } | { "id": number, "title": string, "content": string, "userName": string, "createAt": DateTime, "updateAt": DateTime } | 200   |
