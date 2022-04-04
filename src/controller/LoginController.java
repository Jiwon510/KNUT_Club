package controller;

import entity.NoticeEntity;
import entity.UserEntity;
import service.NoticeService;
import service.SignService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/view/login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String studentID = request.getParameter("studentID");
        String password = request.getParameter("password");
        String authority = request.getParameter("authority");

        HttpSession session = request.getSession();
        session.setAttribute("authority", authority);
        session.setAttribute("studentID", studentID);

        SignService service = new SignService();
        List<UserEntity> list = service.doLogin(studentID, password);
        request.setAttribute("list", list);

        request.getRequestDispatcher("/view/index/index.jsp").forward(request, response);

//        String query = "SELECT studentID, password from userTBL WHERE studentID = ? AND password = ? AND authority = ?";
//        Connection conn = null;
//        PreparedStatement pst = null;
//        ResultSet rs = null;
//
//        String dbURL = "jdbc:mysql://localhost:4406/test";
//        String dbID = "root";
//        String dbPassword = "root";
//
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
//            pst = conn.prepareStatement(query);
//
//            pst.setString(1, studentID);
//            pst.setString(2, password);
//            pst.setString(3, authority);
//            rs = pst.executeQuery();
//
//
//            if (rs.next()) {
//                response.sendRedirect("/index");
//            } else {
//                if (studentID.equals("") && password.equals(""))
//                    out.print("<script>alert('아이디와 비밀번호를 작성해주세요')</script>");
//
//                else if (studentID.equals(""))
//                    out.print("<script>alert('아이디를 확인해주세요')</script>");
//
//                else if (password.equals(""))
//                    out.print("<script>alert('비밀번호를 확인해주세요')</script>");
//                out.print("<script>location.href='/view/login/login.jsp'</script>");
//                out.close();
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            try {
//                if (rs != null)
//                    rs.close();
//
//                if (pst != null)
//                    pst.close();
//
//                if (conn != null)
//                    conn.close();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
    }
}
