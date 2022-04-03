package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "JoinController", value = "/join")
public class JoinController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        /* 생년월일 조합 */
        String birth_yy = request.getParameter("yy");
        String birth_mm = request.getParameter("mm");
        String birth_dd = request.getParameter("dd");

        if (birth_mm.length() == 1)
            birth_mm = '0' + birth_mm;

        if (birth_dd.length() == 1)
            birth_dd = '0' + birth_dd;

        /* 이메일 조합 */
        String email_ = request.getParameter("email");
        String domain = request.getParameter("domain");

        /* 전화번호 조합 */
//		String phone_1 = request.getParameter("phone_1");
//		String phone_2 = request.getParameter("phone_2");
//		String phone_3 = request.getParameter("phone_3");

        String name = request.getParameter("name");
        String studentID = request.getParameter("studentID");
        String password = request.getParameter("password");
        String department = request.getParameter("department");
        String birth = birth_yy + "." + birth_mm + "." + birth_dd;
        String gender = request.getParameter("gender");
        String email = email_ + "@" + domain;
//		String phone = phone_1 + "-" + phone_2 + "-" + phone_3;
        String address = request.getParameter("address");
        String detailaddress = request.getParameter("detailaddress");
//		String motive = request.getParameter("motive");
        String authority = request.getParameter("authority");

//		JoinService service = new JoinService();
//		List<User> list = service.getjoin(name, studentID, password, department, birth,
//				gender, email, phone, address, detailaddress, authority);

        response.sendRedirect("/VIEW/login/login.jsp");
    }
}
