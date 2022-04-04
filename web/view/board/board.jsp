<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>자유게시판</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/view/board/board.css">
</head>

<body>
<div class="topnav">
    <a href="/login">Login</a>
    <a href="/index">Home</a>
    <div class="search-container">
        <form action="/action_page.php">
            <input type="text" placeholder="Search.." name="search">
            <button type="submit"><img id="searchicon" src="/view/board/images/search.png" alt=""><i class="fa fa-search"></i></button>
        </form>
    </div>


</div>

<div class="navbar">
    <div class="logo">
        <a href="/index"><img src="/view/board/images/logo.jpg"></a>
    </div>

    <div id="menu">
        <ul>
            <li><a href="/notice">공지사항</a>
            </li>
            <li><a href="/board">자유게시판</a>

            </li>
            <li><a href="#">가입</a>
                <ul>
                    <li><a href="#">충주캠퍼스</a></li>
                    <li><a href="#">의왕캠퍼스</a></li>
                    <li><a href="#">증평캠퍼스</a></li>
                </ul>
            </li>
            <li><a href="#">소개</a>
                <ul>
                    <li><a href="#">동아리란?</a></li>
                    <li><a href="#">가입 방법</a></li>
                </ul>
            </li>
            <li><a href="#">행사</a>
                <ul>
                    <li><a href="#">동아리 행사</a></li>
                    <li><a href="#">동아리 페어</a></li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<div class="pathbox">
    <h2>Pathbox</h2>
</div>

<div class="row">
    <div class="column side">

        <ul class="sidemenu">
            <h2>Menu</h2>
            <li><a href="/notice">공지사항</li>
            <li id="now"><a href="/board">자유게시판</a></li>
            <li><a href="#">가입</a></li>
            <li><a href="#">소개</a></li>
            <li><a href="#">행사</a></li>
        </ul>
    </div>

    <div class="column middle">
        <h1><a href="/board">자유게시판</h1>

        <form action="/board" method="get">
            <div class="row">
                <div class="col-md-8 mb-3">
                    <select class="custom-select d-block w-100" name="search">
                        <option ${(param.search == "title")?"selected":""} value="title">제목</option>
                        <option ${(param.search == "writer")?"selected":""}
                                value="writer">작성자</option>
                    </select> <input type="text" class="form-control" name="word"
                                     placeholder="" value="${param.word}" required> <input
                        type="submit" value="검색">
                </div>
            </div>
        </form>

        <form action="/board" method="post">
            <table>
                <tr id="tableheader">
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>조회</th>
                    <th>파일</th>
                    <th scope="cols">선택</th>
                </tr>

                <tbody>
                <c:forEach var="n" items="${list}">
                    <input type="hidden" name="n" value=${n.num }>
                    <tr>
                        <td>${n.n}</td>
                        <td><a href="/view/boardDetail/boardDetail?num=${n.num}">${n.title }</a></td>
                        <td>${n.writer }</td>
                        <td>${n.date }</td>
                            <%-- <td>${n.hit }</td> --%>
                        <td>0</td>
                        <td>${n.file }</td>
                        <td><input type="checkbox" name="del_id" value="${n.num}"></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
</div>

<c:set var="page" value="${(param.p == null)?1:param.p}" />
<c:set var="startNum" value="${page-(page-1)%5}" />
<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}" />

<div class="indexer margin-top align-right">
    <h3 class="hidden">현재 페이지</h3>
    <div>
        <span class="text-orange text-strong">${(param.p==null)?1:param.p}/ ${lastNum} </span> pages
    </div>
</div>

<div class="margin-top align-center pager">


    <c:set var="page" value="${(param.p == null)?1:param.p}"/>
    <c:set var="startNum" value="${page-(page-1)%5}"/>
    <c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10), '.')}"/>

    <div>
        <c:if test="${startNum>1}">
            <a href="?p=${startNum-1}&search=${param.search}&word=${param.word}">이전</a>
        </c:if>
        <c:if test="${startNum<=1}">
            <span onclick="alert('이전 페이지가 없습니다.');">이전</span>
        </c:if>

    </div>

    <ul class="list">
        <c:forEach var="i" begin="0" end="4">
            <c:if test="${(startNum+i) <= lastNum }">
                <li><a href="?p=${startNum+i}&search=${param.search}&word=${param.word}">${startNum+i}</a></li>
            </c:if>
        </c:forEach>
    </ul>

    <div>
        <c:if test="${startNum+4<lastNum}">
            <a href="?p=${startNum+5}&search=${param.search}&word=${param.word}">다음</a>
        </c:if>
        <c:if test="${startNum+4>=lastNum }">
            <span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
        </c:if>
    </div>


    <div>
        <button class="btn btn-danger btn-lg btn-block" style="float: right;" type="submit">삭제</button>
    </div>
    </form>
    <div>
        <button class="btn btn-success btn-lg btn-block" onclick="location.href='/view/boardWrite/boardWrite.jsp'" style="float:right;" type="submit">글쓰기</button>
    </div>

    <div class="footer">
        <p>Footer</p>
    </div>
</body>
</html>