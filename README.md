# woowacourse-open-mission

# 🎯 오픈 미션: MVC 패턴의 필요성 체험 프로젝트

## ✅ 미션 목적

현대 웹 개발에서는 MVC 패턴이 당연하게 사용된다.  
하지만 *왜* MVC가 필요한지, 그리고 *MVC를 사용하지 않으면 얼마나 유지보수가 힘들어지는지*를 **직접 체험하는 과정**이 중요하다고 생각하여
이번 미션을 하게 되었다.

이 미션에서는 **90년대 ~ 00년대 선배 개발자들의 방식**으로 웹 애플리케이션을 점진적으로 개선하며  
**MVC 패턴이 가지는 의미를 몸으로 이해하는 것**을 목표로 한다.


## 🚀 개발 환경

| 항목 | 사용 기술 |
|---|---|
| 언어 | Java 8+ |
| 서버 | **Tomcat (수동 실행)** |
| 배포 방식 | **WAR 방식 배포** |
| View | JSP |
| Servlet Spec | javax.servlet.* |



## 🏗️ 단계별 구현

### 1단계 – 단일 서블릿 구조 (스파게티 코드 체험)

**🎯 목표:**  
하나의 서블릿이 요청 처리 + 비즈니스 로직 + HTML 렌더링을 모두 수행하도록 구현하여  
**MVC 이전 방식의 유지보수 지옥을 체험한다.**



### 2단계 – JSP로 View 분리

**🎯 목표**

- 출력(View)은 JSP에서 처리하고
- Servlet은 Controller 역할(요청 수신 + 데이터 전달)만 담당한다.
- “JSP는 HTML+표현, Controller는 흐름 제어” 라는 감각을 익힌다.


### 3단계 – Model(Service) 분리 (MVC 패턴 완성)

**🎯 목표**

비즈니스 로직을 Service 클래스로 분리하여 Controller의 책임을 줄인다.
MVC의 Model, View, Controller 역할이 명확하게 분리된 구조를 만든다.


### ✅ 로또 API

| 기능              | 설명                     | 요청 방식 | 엔드포인트            |
| --------------- | ---------------------- | ----- | ---------------- |
| 로또 구입 입력 화면     | 사용자에게 금액 입력받기          | GET   | `/lotto`         |
| 로또 번호 생성        | 금액에 따라 로또 번호 자동 생성     | POST  | `/lotto`         |
| 당첨번호 결과 조회      | 로또번호 vs 당첨번호 비교        | GET   | `/lotto/result`  |
| 로또 히스토리 조회 (선택) | 지금까지 구매한 번호 확인 (확장 가능) | GET   | `/lotto/history` |



1) 로또 구매 화면
```
GET /lotto
```
→ HTML/JSP Form 으로 금액 입력 페이지 제공

2) 로또 번호 생성 (구매)
```
POST /lotto
Content-Type: application/x-www-form-urlencoded

amount=5000
```
→ Controller → Service → 번호 5세트 생성
→ View(result.jsp) 로 forward

3) 당첨 번호 결과 확인 (사용자 입력 or 고정)
```
GET /lotto/result?winning=1,7,15,23,34,42&bonus=5
```
→ 로또 당첨 여부 계산해서 View로 전달


4) 구매 내역 확인 (선택 사항)
```
GET /lotto/history
```
→ 지금까지 구매한 로또 목록 출력 (Model 저장 구현 선택)


### 🎨 View 흐름
| 페이지                | 설명                   |
| ------------------ | -------------------- |
| `lotto.jsp`        | 금액 입력 Form           |
| `result.jsp`       | 생성된 로또 번호 + 당첨 여부 출력 |
| `history.jsp` (옵션) | 이전 기록 목록 출력          |



