<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>로그인</title>
    <link rel="stylesheet" href="/view/login/login.css">
    <script type="text/javascript" src="/view/login/login.js"></script>

</head>

<body>
<header>
    <a href="/view/index/index.jsp"><img id="logo" src="/view/login/images/header_logo.jpg"></a>
    <h1>KNUT-CLUB</h1>
</header>


<section>
    <div class="login-form">
        <div class="tab">
            <button class="tablinks active" onclick="openTab(event, 'tab1')">회원</button>
            <button class="tablinks" onclick="openTab(event, 'tab2')">관리자</button>
        </div>
        <div id="tab1" class="tabcontent" style="display: block;">
            <form class="login-Form" action="/login" method="post">
                <input type="hidden" name="authority" value="1">
                <h2>회원 로그인</h2>
                <div class="login-Form-inner">
                    <div class="idform">
                        <input type="text" name="studentID" id="id" placeholder="학번"><br>
                    </div>
                    <div class="pwform">
                        <input type="password" name="password" id="pw" placeholder="비밀번호">
                    </div>
                    <button id="btn" type="submit"><strong>로그인</strong></button>
                    <div class="links">
                        <button class="links-btn" type="button" onclick="location.href='/agreement'">
                            <strong>회원가입</strong></button>
                        <button class="links-btn" type="button" onclick="location.href='/view/find/find.jsp'"><strong>PW
                            재설정</strong></button>
                    </div>
                </div>
            </form>


        </div>
        <div id="tab2" class="tabcontent" style="display: none;">
            <form class="login-Form" action="/login" method="post">
                <input type="hidden" name="authority" value="2">
                <h2>관리자 로그인</h2>
                <div class="login-Form-inner">
                    <div class="idform">
                        <input type="text" name="studentID" id="id" placeholder="학번"><br>
                    </div>
                    <div class="pwform">
                        <input type="password" name="password" id="pw" placeholder="비밀번호">
                    </div>
                    <button id="second-btn" type="submit"><strong>로그인</strong></button>

                </div>
            </form>


        </div>

        <script type="text/javascript" src="login.jsp"></script>
    </div>
</section>

<footer>
    <img src="/view/login/images/logo.png">
    <ul class="footer-list">
        <li class="item"><strong>국립한국교통대:</strong> <a href="https://www.ut.ac.kr/">https://www.ut.ac.kr/</a></li>
        <span id="item-developer"><li>Web Developers</li></span>
        <li class="item"><strong>1726066 류지원</strong> E-mail: won97051@gmail.com</li>
        <li class="item"><strong>1726010 김종원</strong> E-mail: kng05310@a.ut.ac.kr</li>
        <li class="item"><strong>1726025 신현식</strong> E-mail: car5800@naver.com</li>
    </ul>

    <ul class="footer-second-list">
        <li class="item"><strong>충주캠퍼스</strong> 주소: 27469 충청북도 충주시 대학로 50</li>
        <li class="item"><strong>증평캠퍼스</strong> 주소: 27909 충청북도 증평군 대학로 61</li>
        <li class="item"><strong>의왕캠퍼스</strong> 주소16106 경기도 의왕시 철도박물관로 157</li>
    </ul>

    <ul class="footer-third-list">
        <li class="item"><strong>TEL</strong>.043-841-5114</li>
        <li class="item"><strong>TEL</strong>.043-820-5114</li>
        <li class="item"><strong>TEL</strong>.031-460-0500</li>
    </ul>
</footer>

</body>
</html>
