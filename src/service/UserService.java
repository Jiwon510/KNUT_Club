package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    /*회원리스트*/
    public List<User> getUser(String field, String query, int page) {

        List<User> list = new ArrayList<>();
        String sql = "SELECT num, name, studentID, department FROM userTBL WHERE authority = 1"
                + " AND " + field + " LIKE ? ";

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
            pst.setString(1, "%" + query + "%");

            rs = pst.executeQuery();

            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String studentID = rs.getString("studentID");
                String department = rs.getString("department");

                User user = new User(
                        num
                        , name
                        , studentID
                        , department
                );
                list.add(user);

            }
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
    /*비회원리스트*/
    public List<User> getNonUser(String field, String query, int page) {

        List<User> list= new ArrayList<>();

        String sql = "SELECT num, name, studentID, department FROM userTBL WHERE authority = 0"
                + " AND " +field+ " LIKE ? ";

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
            pst.setString(1, "%" + query + "%");

            rs = pst.executeQuery();

            while(rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                String studentID = rs.getString("studentID");
                String department = rs.getString("department");

                User user = new User(
                        num
                        ,name
                        ,studentID
                        ,department
                );
                list.add(user);

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if(rs != null)
                    rs.close();

                if(pst != null)
                    pst.close();

                if(conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return list;
    }

    /*회원 수*/
    public int getUserCount(String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM userTBL where authority = 1";

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
            rs = pst.executeQuery();

            if(rs.next())
                count = rs.getInt("count");

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
        return count;
    }

    /*비회원 수*/
    public int getNonUserCount(String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM userTBL where authority = 0";

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
            rs = pst.executeQuery();

            if(rs.next())
                count = rs.getInt("count");

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
        return count;
    }
    /*회원 이름*/
    public String getUserName(String studentID) {
        String name = null;

        String sql = "SELECT name FROM userTBL where studentID = ?";

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

            rs = pst.executeQuery();

            if(rs.next())
                name = rs.getString("name");

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
        return name;
    }

    /*회원&비회원 삭제*/
    public int delUser(int[] ids) {
        int result = 0;

        String params = "";

        for (int i=0; i<ids.length; i++) {
            params += ids[i];
            if(i<ids.length-1)
                params += ",";
        }

        String sql = "DELETE FROM userTBL WHERE num IN ("+params+")";

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        String dbURL = "jdbc:mysql://localhost:4406/test";
        String dbID = "root";
        String dbPassword = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
            st = conn.createStatement();

            result = st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null)
                    rs.close();

                if (st != null)
                    st.close();

                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }

}
