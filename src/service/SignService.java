package service;

import entity.UserEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SignService {
    public List<UserEntity> doLogin(String studentID, String password) {
        List<UserEntity> list = new ArrayList<>();

        String sql = "SELECT studentID, password FROM userTBL WHERE studentID = ? and password = ?";

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/test";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, studentID);
            pst.setString(2, password);

            rs = pst.executeQuery();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();

                if (pst != null)
                    pst.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }
}
