# woowacourse-open-mission

#  오픈 미션: 90년대 개발자처럼 시작해서 현대 MVC로 진화하기

##  미션 목적

현대 웹 개발에서는 MVC 패턴이 당연하게 사용됩니다.  
그럼 **90년대 후반~00년대 초반 선배 개발자들은 어떻게 개발했을까요?**

이번 미션은 그 시절 방식으로 **3주차 미션인 로또를 기능을 더 추가**하여 웹 서비스를 구현해 본 뒤, 그 시절의 불편함을 직접 체험하고   
**점진적으로 MVC 패턴으로 리팩토링**하면서 *왜 MVC가 필요한지*를 느끼는 것이 목표입니다.


### 새롭게 추가한 기능

기존 로또 규칙을 유지하면서 웹 서비스 형태에 맞게 다음과 같은 기능을 추가 구현했습니다.

- 사용자는 로또를 여러 번 나누어 구매할 수 있다.
   - 이전에는 한 번의 금액만 입력 가능했지만 웹 리팩토링 이후에는 여러 번의 구매 기록을 누적하여 관리할 수 있도록 개선했습니다.
   - 예: 첫 구매 6,000원 → 두 번째 구매 8,000원
- 사용자는 자신의 로또 당첨 결과를 조회할 수 있다.
   - 구매한 로또 목록을 저장하고 서버에서 계산한 결과를 기반으로 각 회차별 당첨 여부를 확인할 수 있는 조회할 수 있습니다.
- 당첨 로또 번호는 서버에서 매번 랜덤 생성
   - 사용자마다 한 회차의 ‘당첨 번호’를 서버가 랜덤 생성합니다. 
- 회원가입/로그인 기반의 접근 제어 기능 추가
   - 웹 서비스로 확장하면서 세션 기반 회원가입과 로그인 기능을 도입했고 로그인한 사용자만 로또 구매 가능하도록 구현했습니다. 

### 학습 포인트
- **1단계**: 서블릿 하나에 모든 코드가 들어있는 **90년대 스파게티 코드** 체험
- **2단계**: JSP 등장 이후, View를 분리하면서 얻는 **00년대 초반 개발 스타일** 체험
- **3단계**: **Front Controller를 적용하여 공통 로직 분리**
- **최종**: 현대 MVC 구조의 필요성을 체감하고 이해하기


## 개발 환경

| 항목 | 사용 기술 |
|---|---|
| 언어 | Java 21 |
| 빌드 도구 | Gradle |
| 서버 | **Apache Tomcat 10.x** |
| View | JSP |
| Servlet Spec | jakarta.servlet.* (Servlet 6.0) |


##  실행 방법

> ⚠️ **중요: 이 프로젝트는 내장 톰캣을 사용하지 않습니다!**  
> 90년대~00년대 개발 방식을 체험하기 위해 **Apache Tomcat을 직접 설치하고 WAR 파일을 수동으로 배포**해야 합니다.  
> Spring Boot의 편리함을 느끼기 전에, 선배 개발자들이 겪었던 배포 과정을 경험해보세요! 

### 1️⃣ Tomcat 설치

#### 방법 1: Homebrew 사용 (macOS 추천)

```bash
# Homebrew를 통한 Tomcat 설치 (macOS)
brew install tomcat

# Tomcat 설치 경로 확인
brew --prefix tomcat
# 보통 /usr/local/opt/tomcat 또는 /opt/homebrew/opt/tomcat
```

#### 방법 2: 공식 웹사이트에서 직접 다운로드

1. **Apache Tomcat 10 다운로드 페이지 접속**  
   👉 https://tomcat.apache.org/download-10.cgi

2. **Download 메뉴에서 Core 섹션 찾기**  
   - `zip` 파일을 선택하여 다운로드 (Windows/macOS 모두 사용 가능)
   - 또는 `tar.gz` 파일 선택 (Linux/macOS)

3. **압축 풀기**
   
   다운로드한 파일을 원하는 위치에 **그냥 압축 풀어도 됩니다!**
   
   > 💡 명령어를 사용하고 싶다면 아래 방법을 참고하세요 (선택사항)
   
   ```bash
   # 다운로드한 파일 압축 해제
   unzip apache-tomcat-10.x.x.zip
   # 또는
   tar -xzf apache-tomcat-10.x.x.tar.gz
   ```

4. **톰캣 실행 설정**

   **MAC, 리눅스 사용자**
   
   `톰캣폴더/bin` 폴더로 이동
   ```bash
   cd /usr/local/tomcat/bin
   
   # 권한 주기
   chmod 755 *
   
   # 실행
   ./startup.sh
   
   # 종료
   ./shutdown.sh
   ```
   
   > ⚠️ **참고**: MAC, 리눅스 사용자는 권한을 주지 않으면 `permission denied` 라는 오류가 발생할 수 있습니다.

   **윈도우 사용자**
   
   `톰캣폴더/bin` 폴더로 이동
   ```bash
   # 실행
   startup.bat
   
   # 종료
   shutdown.bat
   ```

### 2️⃣ 프로젝트 빌드

```bash
# 프로젝트 루트 디렉토리에서 실행
./gradlew clean build

# WAR 파일 생성 확인
# build/libs/open-mission-0.0.1-SNAPSHOT.war 생성됨
```

### 3️⃣ Tomcat에 배포

이렇게 생성된 WAR 파일을 톰캣 서버에 실제 배포해보자.

1. **톰캣 서버를 종료한다.**
   ```bash
   ./shutdown.sh
   ```

2. **`톰캣폴더/webapps` 하위를 모두 삭제한다.**
   ```bash
   rm -rf /usr/local/tomcat/webapps/*
   ```

3. **빌드된 `open-mission-0.0.1-SNAPSHOT.war`를 복사한다.**
   ```bash
   cp build/libs/open-mission-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
   ```

4. **이름을 변경한다.** `톰캣폴더/webapps/ROOT.war`
   ```bash
   mv /usr/local/tomcat/webapps/open-mission-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
   ```

5. **톰캣 서버를 실행한다.**
   ```bash
   ./startup.sh
   ```

### 4️⃣ 접속 확인

브라우저에서 http://localhost:8080 접속

> ⚠️ **포트 변경이 필요한 경우**  
> 톰캣 설치 경로의 `conf/server.xml` 파일에서 `Connector port="8080"` 부분을 수정하세요.


##   단계별 구현

### 1단계 – 단일 서블릿 구조 (스파게티 코드 체험) 

**🎯 목표:**  
- 하나의 서블릿이 **요청 처리 + 비즈니스 로직 + HTML 렌더링**을 모두 수행하도록 구현합니다.  
- **문자열(String)로 HTML을 직접 생성**하여 응답합니다.
- **MVC 이전 방식의 유지보수 지옥을 체험합니다.**

**📂 구현 내용:**
- 서블릿 내부에서 `response.getWriter().println("<html>...")` 형태로 HTML 생성
- 비즈니스 로직(로또 번호 생성, 당첨 확인 등)도 서블릿 안에 직접 작성
- 모든 로직이 하나의 클래스에 섞여있어 코드 가독성 최악
- HTML 수정 시 서블릿 코드를 직접 수정해야 하는 불편함


### 2단계 – JSP로 View 분리 + Model 분리

**목표:**

- **출력(View)은 JSP에서 처리**하도록 리펙토링 합니다.
- Servlet은 Controller 역할(요청 수신 + 데이터 전달)만 담당합니다.
- "JSP는 HTML+표현, Servlet은 흐름 제어"의 역할만 하도록 합니다.
- **request.setAttribute()를 통해 모델 데이터를 JSP에 전달**합니다.
- **RequestDispatcher.forward()를 사용**하여 JSP로 제어를 넘깁니다.

**구현 내용:**
- Servlet: 비즈니스 로직 실행 → 결과를 request에 담음 → JSP로 forward
- JSP: request에서 데이터를 꺼내 화면에 표현 (EL, JSTL 사용)
- 중복된 비즈니스 로직은 별도 메서드나 클래스로 일부 분리

**기술 포인트:**
```java
// Servlet에서
request.setAttribute("lottoTickets", tickets);
request.getRequestDispatcher("/WEB-INF/views/lotto-issued.jsp").forward(request, response);

// JSP에서
${lottoTickets}  // EL 표현식으로 데이터 접근
<c:forEach items="${lottoTickets}" var="ticket">...</c:forEach>  // JSTL 태그
```


### 3단계 – Session + Front Controller 패턴 (MVC 완성) 

**목표:**

- **Session을 이용한 로그인 기능** 구현
- **Front Controller 패턴**을 적용하여 서블릿 입구를 하나로 통일
- **Controller 클래스 분리**로 각 요청별 처리 로직 독립
- **현재 Spring MVC 구조와 유사한 형태**로 발전
- 비즈니스 로직을 Service 클래스로 완전히 분리

**구현 내용:**

#### 1) Session 기반 로그인
- 사용자 로그인 시 Session에 사용자 정보 저장
- 로그인 여부를 Session으로 확인
- 로그아웃 시 Session 무효화

#### 2) Front Controller 패턴
- 모든 요청을 하나의 서블릿(FrontController)이 받음
- URL 패턴에 따라 적절한 Controller로 라우팅
- 공통 처리 로직(인증, 로깅 등)을 한 곳에서 관리

#### 3) Controller 분리
- 각 기능별로 독립적인 Controller 클래스 생성
- Controller는 Service를 호출하고 View 이름을 반환
- Service는 순수한 비즈니스 로직만 담당


## 🎰 로또 서비스 API 구조

### 최종 API (3단계 - Session + Front Controller 패턴)

| 기능 | 설명 | 요청 | URL |
|------|------|-----|-----|
| 회원가입 화면 | 회원가입 폼 | GET | `/v3/servlet/jsp/join-form` |
| 회원가입 처리 | 회원 정보 등록 | POST | `/v3/servlet/jsp/register` |
| 로그인 화면 | 로그인 폼 | GET | `/v3/servlet/jsp/login-form` |
| 로그인 처리 | Session에 사용자 정보 저장 | POST | `/v3/servlet/jsp/login` |
| 메인 화면 | 로그인 후 메인 화면 | GET | `/v3/servlet/jsp` |
| 로또 구매 입력 | 이름, 금액 입력 폼 | GET | `/v3/servlet/jsp/lotto` |
| 로또 번호 생성 | 금액에 따라 로또 번호 생성 | POST | `/v3/servlet/jsp/buy` |
| 당첨 번호 입력 | 당첨 번호 입력 폼 | GET | `/v3/servlet/jsp/winning` |
| 당첨 번호 생성 | 당첨 번호 생성 및 저장 | POST | `/v3/servlet/jsp/winning` |
| 현재 결과 확인 | 현재 로그인한 사용자의 당첨 결과 | GET | `/v3/servlet/jsp/current-result` |
| 전체 결과 확인 | 당첨 통계 표시 | GET | `/v3/servlet/jsp/result` |
| 이력 조회 | 전체 사용자 이력 | GET | `/v3/servlet/jsp/history` |

> 💡 **특징:**
> - 모든 요청이 **FrontController** (`/v3/servlet/jsp/*`)를 통해 처리됩니다
> - URL 패턴에 따라 적절한 Controller로 라우팅됩니다
> - Session을 통한 로그인/회원가입 기능이 포함되어 있습니다


###  요약 흐름 다이어그램

```text
모든 요청 → /v3/servlet/jsp/* (FrontController)
├─ GET /v3/servlet/jsp/join-form → 회원가입 화면
├─ POST /v3/servlet/jsp/register → 회원가입 처리
├─ GET /v3/servlet/jsp/login-form → 로그인 화면
├─ POST /v3/servlet/jsp/login → 로그인 처리 (Session 생성)
├─ GET /v3/servlet/jsp → 메인 화면 (로그인 필수)
├─ GET /v3/servlet/jsp/lotto → 구매 입력 폼
├─ POST /v3/servlet/jsp/buy → 로또 번호 생성
├─ GET /v3/servlet/jsp/winning → 당첨 번호 입력
├─ POST /v3/servlet/jsp/winning → 당첨 번호 생성
├─ GET /v3/servlet/jsp/current-result → 내 당첨 결과
├─ GET /v3/servlet/jsp/result → 전체 당첨 결과
└─ GET /v3/servlet/jsp/history → 전체 이력 조회

✨ FrontController가 모든 요청을 받아 적절한 Controller로 라우팅
```

###  프로젝트 구조

```
src/main/
├── java/com/woowacourse/open_mission/
│   ├── servlet/              # 1단계: 단일 서블릿
│   ├── servletJsp/           # 2단계: JSP 분리
│   └── servletJspSession/    # 3단계: Session + Front Controller
│       ├── servlet/
│       │   ├── FrontController.java
│       │   └── LottoController.java
│       ├── service/
│       └── domain/
└── webapp/
    └── WEB-INF/
        ├── views/            # 2단계 JSP 파일
        └── viewsV2/          # 3단계 JSP 파일 (로그인 포함)
```


