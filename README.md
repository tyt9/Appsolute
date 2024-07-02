# Appsolute
**전자 결재 시스템** 입니다.<br><br><br>

### 개발 기간
* 2023.09.18 ~ 2023.10.19 (약 한달)<br><br>

### 팀원 구성
* **팀장 : 본인 - ERD 설계, 결재 기능, 발표**
* 팀원1 : 로그인/마이 페이지 기능, 소스 통합
* 팀원2 : 공지사항 게시판, CSS
* 팀원3 : 정보 수정, 사원 검색 등 관리 기능
* 팀원4 : 메세지 기능, 소스 통합<br><br>

### 개발 환경
* Java 11
* **프레임워크** : Spring boot(2.7.15)
* **데이터베이스** : Mysql - MyBatis
* **프론트** : thymeleaf, javascript, jQuery<br><br>

### 나의 역할
* **ERD 설계**
  
  <details><summary><b>ERD 이미지</b></summary>
  <div>
    <img src="src/main/resources/static/image/APPSOLUTEERD.png">
  </div>
</details>

문서의 종류마다 테이블을 추가하지 않고도 데이터를 저장하고 불러올 수 있도록 구성함

* **기능 구현**
  
<details><summary><b>문서 작성 기능</b></summary>
  <div>
    <img src="src/main/resources/static/image/스크린샷 2024-07-02 190726.png">
  </div>
</details>

     * 작성하는 사람의 정보는 로그인 정보로 자동으로 입력됨
     * 작성한 문서에 결재를 받을 사람을 선택하여 올릴 수 있다.


  <details><summary><b>받은 결재함</b></summary>
  <div>
    <img src="src/main/webapp/img/스크린샷 2024-06-10 181246.png">
  </div>
</details>
  
     * 

  <details><summary><b>내가 올린 결재</b></summary>
  <div>
    <img src="src/main/webapp/img/스크린샷 2024-06-10 181545.png">
    <img src="src/main/webapp/img/스크린샷 2024-06-10 184327.png">
  </div>
</details>

     * 



