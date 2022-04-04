<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <title>KNUT_LUB</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/view/index/index.css">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>

<body>
<div class="topnav">
    <a href="/login">Login</a>
    <a href="/index">Home</a>
    <div class="search-container">
        <form action="/action_page.php">
            <input type="text" placeholder="Search.." name="search">
            <button type="submit">
                <img id="searchicon" src="/view/index/images/search.png" alt=""><i
                    class="fa fa-search"></i>
            </button>
        </form>
    </div>
</div>

<div class="navbar">
    <div class="logo">
        <a href="/index"><img src="/view/index/images/logo.jpg"></a>
    </div>

    <div id="menu">
        <ul>
            <li><a href="/notice">공지사항</a></li>
            <li><a href="/board">자유게시판</a></li>
            <li><a href="#">가입</a>
                <ul>
                    <li><a href="#">충주캠퍼스</a></li>
                    <li><a href="#">의왕캠퍼스</a></li>
                    <li><a href="#">증평캠퍼스</a></li>
                </ul></li>
            <li><a href="#">소개</a>
                <ul>
                    <li><a href="#">동아리란?</a></li>
                    <li><a href="#">가입 방법</a></li>
                </ul></li>
            <li><a href="#">행사</a>
                <ul>
                    <li><a href="#">동아리 행사</a></li>
                    <li><a href="#">동아리 페어</a></li>
                </ul></li>
            <c:if test="${authority eq '2'}">
                <li><a href="#">회원관리</a>
                    <ul>
                        <li><a href="/view/management/userList">회원목록</a></li>
                        <li><a href="/view/management/non_userList">승인목록</a></li>
                    </ul></li>
            </c:if>
        </ul>
    </div>
</div>

<div class="picture">
    <img src="/view/index/images/mainpicture.jpg">
</div>

<div class="row">

    <div class="column middle">
        <h2>Main Content</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque
            ultricies, eget elementum magna tristique. Quisque vehicula, risus
            eget aliquam placerat, purus leo tincidunt eros, eget luctus quam
            orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque
            ultricies, eget elementum magna tristique. Quisque vehicula, risus
            eget aliquam placerat, purus leo tincidunt eros, eget luctus quam
            orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
    </div>
    <div class="column middle">
        <h2>Main Content</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque
            ultricies, eget elementum magna tristique. Quisque vehicula, risus
            eget aliquam placerat, purus leo tincidunt eros, eget luctus quam
            orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Maecenas sit amet pretium urna. Vivamus venenatis velit nec neque
            ultricies, eget elementum magna tristique. Quisque vehicula, risus
            eget aliquam placerat, purus leo tincidunt eros, eget luctus quam
            orci in velit. Praesent scelerisque tortor sed accumsan convallis.</p>
    </div>



</div>

<div class="footer">
    <p>Footer</p>
</div>
</body>
