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
    <img src="src/main/resources/static/image/스크린샷 2024-07-08 173557.png">
  </div>
</details>
  
     * 받은 결재함에는 내가 받은 문서들이 미결/승인/반려 로 분류되어 나옴
     * 미결함에 있는 문서를 클릭해 승인 또는 반려를 하면 문서가 승인함 또는 반려함 으로 분류됨
     * 결재 절차에 따라 이전사람이 승인하지 않으면 다음번 사람에게 보이지 않음
     * 마지막 사람이 결재를 완료하면 최종적으로 승인 또는 반려로 표시

  <details><summary><b>내가 올린 결재</b></summary>
  <div>
    <img src="src/main/resources/static/image/스크린샷 2024-07-08 175259.png">
  </div>
</details>

     * 받은 결재함과 동일하게 내가 올린 문서들이 미결/승인/반려로 분류되어 나옴
     * 여기서는 최종 승인 또는 반려되어야 승인 또는 반려함으로 분류됨



