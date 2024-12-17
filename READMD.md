# 환경 설정
## Postgresql
마운트 경로는 자신의 PC에 맞게 수정해주세요.
```bash 
docker run -d --name postgresql \
-p 5432:5432 \
-v /Users/kwon-yeseong/Documents/db/postgresql:/var/lib/postgresql/data \ 
-e POSTGRES_PASSWORD=testpassword \
postgres:17.2-alpine
```