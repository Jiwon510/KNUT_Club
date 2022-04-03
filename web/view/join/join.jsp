<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lnag="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <link rel="stylesheet" href="/view/join/join.css">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript" src="/view/join/join.js"></script>

</head>


<body>

<!-- header -->
<div id="header">
    <a href="VIEW/login/login.jsp"><img src="/view/join/images/header_logo.jpg" id="logo"></a>
</div>


<!-- wrapper -->
<div id="wrapper">
    <form action="/join" method="post">

        <!-- content-->
        <div id="content">

            <!-- NAME -->
            <div>
                <h3 class="join_title"><label for="name">이름</label></h3>
                <span class="box int_name">
                      <input type="text" name="name" id="name" class="int" maxlength="20">
                  </span>
                <span class="error_next_box"></span>
            </div>

            <!-- ID -->
            <div>
                <h3 class="join_title">
                    <label for="studentID">학번</label>
                </h3>
                <span class="box int_id">
                        <input type="text" name="studentID" id="id" class="int" maxlength="20">

                    </span>
                <span class="error_next_box"></span>
            </div>

            <!-- PW1 -->
            <div>
                <h3 class="join_title"><label for="password">비밀번호</label></h3>
                <span class="box int_pass">
                        <input type="password" name="password" id="pswd1" class="int" maxlength="20">
                        <span id="alertTxt">사용불가</span>
                        <img src="/view/join/images/unlock.jpg" id="pswd1_img1" class="pswdImg">
                    </span>
                <span class="error_next_box"></span>
            </div>

            <!-- PW2 -->
            <div>
                <h3 class="join_title"><label for="pswd2">비밀번호 재확인</label></h3>
                <span class="box int_pass_check">
                        <input type="password" id="pswd2" class="int" maxlength="20">
                        <img src="/view/join/images/unlock.jpg" id="pswd2_img1" class="pswdImg">
                    </span>
                <span class="error_next_box"></span>
            </div>

            <!-- NAME -->
            <div>
                <h3 class="join_title"><label for="name">학과</label></h3>
                <span class="box int_name">
                        <input type="text" id="name" name="department" class="int" maxlength="20">
                    </span>
                <span class="error_next_box"></span>
            </div>

            <!-- BIRTH -->
            <div>
                <h3 class="join_title"><label for="yy">생년월일</label></h3>

                <div id="bir_wrap">
                    <!-- BIRTH_YY -->
                    <div id="bir_yy">
                            <span class="box">
                                <input type="text" name="yy" id="yy" class="int" maxlength="4" placeholder="년(4자)">
                            </span>
                    </div>

                    <!-- BIRTH_MM -->
                    <div id="bir_mm">
                            <span class="box">
                                <select id="mm" name="mm" class="sel">
                                    <option>월</option>
                                    <option value="01">1</option>
                                    <option value="02">2</option>
                                    <option value="03">3</option>
                                    <option value="04">4</option>
                                    <option value="05">5</option>
                                    <option value="06">6</option>
                                    <option value="07">7</option>
                                    <option value="08">8</option>
                                    <option value="09">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </span>
                    </div>

                    <!-- BIRTH_DD -->
                    <div id="bir_dd">
                            <span class="box">
                                <input type="text" name="dd" id="dd" class="int" maxlength="2" placeholder="일">
                            </span>
                    </div>

                </div>
                <span class="error_next_box"></span>
            </div>

            <!-- GENDER -->
            <div>
                <h3 class="join_title"><label for="gender">성별</label></h3>
                <span class="box gender_code">
                        <select id="gender" name="gender" class="sel">
                            <option>성별</option>
                            <option value="남성">남성</option>
                            <option value="여성">여성</option>
                        </select>
                    </span>
                <span class="error_next_box">필수 정보입니다.</span>
            </div>

            <!-- EMAIL -->
            <div class="email-wrap">
                <div id="email-box">
                    <h3 class="join_title"><label for="email">이메일<span class="optional" name="email"></span></label>
                    </h3>
                    <span class="box int_email">
                          <input type="text" name="email_id" id="email_id" class="int" maxlength="100">
                      </span>
                </div>
                <p>@</p>
                <div id="email-box">
                    <h3 class="join_title"><label for="email"><span class="optional" name="email"></span></label></h3>
                    <span class="box int_email">
                          <input type="text" name="email_domain" id="email_domain" class="int" maxlength="100">
                      </span>
                </div>
                <div id="email-box">
                      <span class="box int_email">
                      <!-- id="domain" name="domain" -->
                        <select id="domain" name="domain" onclick="setEmailDomain(this.value);">
                          <option value="">선택</option>
                          <option value="">직접입력</option>
                          <option value="naver.com">naver.com</option>
                          <option value="a.ut.ac.kr">a.ut.ac.kr</option>
                          <option value="gmail.com">gmail.com</option>
                          <option value="daum.net">daum.net</option>
                        </select>

                      </span>
                </div>
                <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>
            </div>

            <!-- MOBILE -->
            <div>
                <h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
                <span class="box int_mobile">
                        <input type="tel" name="phone_1" id="mobile_1" class="int" maxlength="16">
                    </span>
                <!--  <span class="box int_mobile">
                     <input type="tel" name="phone_2"  id="mobile_2" class="int" maxlength="16">
                 </span> -
                 <span class="box int_mobile">
                     <input type="tel" name="phone_3"  id="mobile_3" class="int" maxlength="16">
                 </span> -->
                <span class="error_next_box"></span>
            </div>

            <!-- address -->
            <div>
                <h3 class="join_title2">주소</h3>
                <input id="member_post" type="button" value='주소찾기' readonly onclick="findAddr();">


                <span class="box int_address">
                    <input type="text" class="form-control" id="address" name="address"><br>


                  </span>
            </div>

            <div>
                <h3 class="join_title">상세 주소</h3>

                <span class="box int_address">
                    <input type="text" class="form-control" id="address" name="detailaddress"><br>


                  </span>
            </div>

            <!-- 지원동기 -->
            <!-- <div>
              <h3 class="join_title">지원 동기</h3>

              <span class="box_int_motivation">
                <input type="text" class="form-control" name="motive" id="motivation" ><br>


              </span>
            </div> -->

            <!-- 권한 -->
            <input type="hidden" name="authority" value="0">


            <!-- JOIN BTN-->
            <div class="btn_area">
                <button type="submit" id="btnJoin">
                    <span>가입하기</span>
                </button>
            </div>
    </form>
</div>
</div>
<script src="/VIEW/join/join.js"></script>
</body>
</html>