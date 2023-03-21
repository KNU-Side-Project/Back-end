# KNOO(크누)

### KNU(공주대학교) 커뮤니티

> KNU를 그대로 발음한 '크누'를 모티브로 KNOO라는 이름을 지었습니다.

# 🔍 Outline

## 🗓️ Term

2023.03..10 ~ progress

## 👨‍💻 Member

### Front-end

@조성훈

### Back-end

@지찬우

## ⚙️ Detailed Function

- 메인 페이지

### 회원

- 회원가입 / 로그인
- 아이디/비밀번호 찾기
- 회원 정보 조회
- 정보 수정
- 회원 탈퇴

### 커뮤니티

- 카테고리별 게시판
- 글 작성
- 글 조회
- 글 수정
- 글 삭제
- 게시글 검색
- 댓글 작성
- 댓글 조회
- 댓글 삭제
- 대댓글 작성
- 좋아요(게시글, 댓글)

> 추가 기능 추가 예정
>

<br>

# 🛠️ Skills

## 🎨 Front

- HTML/CSS/JS
- React

## 🔩 Back

- JAVA 11
- Spring Boot
- Spring Security
- JPA

## 💾 DB

- MySQL

<br>

# 요구사항 분석

| 요구사항 명   | 기능 명              | 상세 설명                                                                                  | 필수 데이터                                                                |
|----------|-------------------|----------------------------------------------------------------------------------------|-----------------------------------------------------------------------|
| 로그인      | KNOO 자체 회원 로그인    | KNOO에서 회원이 직접 지정한 아이디와 비밀번호를 통해 인증(권한이 나눠지고 권한별로 또는 인증을 받지 못한 경우 특정 기능 사용 제한)          | 아이디, 비밀번호                                                             |
| 로그인      | 자동 로그인            | 자동 로그인 체크 후 로그인 (7일)                                                                   |                                                                       |
| 로그인      | 아이디/비밀번호 찾기       | 아이디 분실 시 이메일을 통해 아이디 전송, 비밀번호 분실 시 아이디, 이메일을 입력해 일치하는 경우 (회원가입과 동일한)이메일 인증을 통해 비밀번호 변경 | 아이디 찾기 : 이메일<br>비밀번호 찾기 : 아이디, 이메일<br>비밀번호 변경 : 새로운 비밀번호, 새로운 비밀번호 확인 |                                                                                      |                                        |
| 회원가입     | KNOO 자체 회원가입      | KNOO에서 회원이 직접 아이디와 비밀번호를 정하고, 닉네임, 공주대학교 이메일을 입력하여 이메일 인증을 받아야 한다. 아이디와 닉네임 유일해야 한다.   | 아이디, 비밀번호, 비밀번호 확인, 닉네임, 공주대학교 이메일(인증)                                |
| 회원 정보 조회 | 마이페이지             | 닉네임이 표시되고 정보 수정 버튼. 내가 작성한 글, 댓글 작성한 게시글, 좋아요 한 게시글 등 리스트 간단히 표시(더보기 버튼으로 모든 게시글 확인)   | 토큰                                                                    |
| 회원 정보 조회 | 내가 작성한 글          | 자신이 작성한 게시글 리스트 확인(최근 작성한 글 순)                                                         | 토큰                                                                    |
| 회원 정보 조회 | 댓글 작성한 게시글        | 자신이 댓글을 작성한 게시글 리스트 확인(최근 작성된 게시글 순)                                                 | 토큰                                                                    |
| 회원 정보 조회 | 좋아요 한 게시글         | 자신이 좋아요 한 게시글 리스트 확인(최근 좋아요 누른 순)                                                     | 토큰                                                                    |
| 정보 수정    | 회원 상세 정보 수정       | 닉네임 수정. (필수는 아니지만 캠퍼스, 학과 입력 가능) 닉네임 중복 불가                                             | 토큰, 닉네임 (캠퍼스, 학과)                                                     |
| 회원 탈퇴    | KNOO 자체 회원 탈퇴     | 탈퇴 버튼을 누르고 자신의 닉네임을 올바르게 입력하면 탈퇴                                                       | 토큰, 닉네임                                                               |
|          |                   |                                                                                        |                                                                       |
| 게시판      | 카테고리별 게시판         |                                                                                        |                                                                       |
| 게시글 작성   | 메인 페이지 글쓰기        | 글쓰기 버튼에 마우스를 올리면 게시판을 선택할 수 있고 해당 게시판에 글을 작성하는 페이지로 이동                                 | 토큰                                                                    |
| 게시글 작성   | 특정 게시판 글쓰기        | 특정 게시판 글쓰기 버튼을 클릭하면 해당 게시판에 글을 작성하는 페이지로 이동                                            | 토큰                                                                    |
| 게시글 작성   | 작성 폼              | 제목, 내용을 입력하고 (필수는 아니지만 사진 업로드) 완료 버튼으로 글 작성                                            | 토큰, 글 제목, 글 내용 (사진)                                                   |
| 게시글 조회   | 다른 회원이 작성한 글 조회   | 작성자 닉네임, 작성 날짜, 제목, 내용, 좋아요 개수, 댓글 표시                                                  | 토큰                                                                    |
| 게시글 조회   | 자신이 작성한 글 조회      | 작성자 닉네임, 작성 날짜, 제목, 내용, 좋아요 개수, 댓글 리스트 표시, 수정, 삭제 버튼 표시                                | 토큰                                                                    |
| 게시글 수정   | 자신이 작성한 글 수정      | 제목, 내용을 수정하고 (필수는 아니지만 사진 업로드) 완료 버튼으로 글 수정                                            | 토큰                                                                    |
| 게시글 삭제   | 자신이 작성한 글 삭제      | 게시글 영구 삭제(포함되는 댓글 모두 삭제)                                                               | 토큰                                                                    |
| 게시글 좋아요  | 작성된 게시글 좋아요       | 좋아요 버튼을 누르면 좋아요 처리(한 번 더 누르면 취소)                                                       | 토큰                                                                    |
| 게시글 검색   | 게시글 검색            | 제목 또는 내용을 선택하고 검색어를 입력 후 검색 버튼을 누르면 해당 조건에 맞는 게시글 리스트 표시                               | 토큰, 검색어, 필터                                                           |
|          |                   |                                                                                        |                                                                       |
| 댓글 작성    | 게시글에 댓글 작성        | 댓글 내용 입력 후 완료 버튼으로 댓글 작성                                                               | 토큰, 댓글 내용                                                             |
| 댓글 조회    | 게시글에 작성된 댓글 조회    | 작성자 닉네임, 작성 날짜, 댓글 내용, 좋아요 버튼 표시 (자신이 작성한 댓글에는 삭제  버튼 표시)                              | 토큰, 게시글 번호                                                            |
| 댓글 삭제    | 자신이 작성한 댓글 삭제     | 댓글 영구 삭제                                                                               | 토큰                                                                    |
| 대댓글 작성   | 작성된 댓글에 대한 대댓글 작성 | 댓글 작성과 동일                                                                              |                                                                       |
| 댓글 좋아요   | 작성된 댓글 좋아요        | 좋아요 버튼을 누르면 좋아요 처리(한 번 더 누르면 취소)                                                       |                                                                       |

<br>

# DB 설계

<img width="100%" alt="스크린샷 2023-03-21 18 55 49" src="https://user-images.githubusercontent.com/69714701/226572690-2b135d44-2c86-4e18-9fc7-708077c33221.png">

# API 명세서
[[Notion] API 명세서](https://woopaca.notion.site/API-63e9efc02bee4a4ebb588282d6e5ee98)




