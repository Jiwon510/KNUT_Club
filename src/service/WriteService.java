package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class WriteService {
    /*공지사항_글작성*/
    public List<Write> WriteNotice(String title, String writer, String content, int like_count) {

        List<Write> list= new ArrayList<>();

        String sql = "INSERT INTO NOTICE(title, writer, content) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pst = null;

        String dbURL = "jdbc:mysql://localhost:4406/test";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            pst = conn.prepareStatement(sql);
            pst.setString(1, title);
            pst.setString(2, writer);
            pst.setString(3, content);


            int rs = pst.executeUpdate();

            Write write = new Write (
                    title
                    ,writer
                    ,content
            );
            list.add(write);


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
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
