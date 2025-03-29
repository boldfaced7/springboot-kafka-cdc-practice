<div align="center">
<h1>📋 Kafka를 이용한 CDC 구현 연습 👨‍💻</h1>
</div>

# 개요
- Kafka를 이용한 Application 레벨 CDC 구현을 연습하는 프로젝트입니다.
- 버전별로 구현 방식에 차이가 있습니다.

# Version 소개
- `v1`: 트랜잭션 내에서 `KafkaTemplate.send()` 직접 호출
- `v2`: Spring의 `@TransactionalEventListener` 사용
- `v3`: JPA의 `@PostPersist` 사용
- `v4`: Outbox Pattern 구현

# 관련 포스팅(작성 중)
[CDC(Change Data Capture)](https://boldfaced7.notion.site/4-CDC-Change-Data-Capture-1c125f2f85d68023bbf5ce851687cf53)
