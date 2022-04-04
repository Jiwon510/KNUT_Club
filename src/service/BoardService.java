package service;

import entity.BoardEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardService {
    public List<BoardEntity> getBoardList(String field, String query, int page) {

        List<BoardEntity> list = new ArrayList<>();

        String sql = "SELECT @ROWNUM := @ROWNUM +1 AS n, Board_VIEW.*"
                + " FROM BOARD_VIEW, (SELECT @ROWNUM := 0)TMP WHERE " +field+ " LIKE ? ORDER BY date DESC limit ?, 10;";

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
            pst.setInt(2, 0+(page-1)*10);

            rs = pst.executeQuery();

            while (rs.next()) {
                int n = rs.getInt("n");
                int num = rs.getInt("num");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                int comment_count = rs.getInt("comment_count");

                BoardEntity Board = new BoardEntity(
                        n
                        , num
                        , title
                        , writer
                        , date
                        , comment_count
                );
                list.add(Board);


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

    public int getBoardCount(String field, String query) {
        int count = 0;

        String sql = "SELECT COUNT(num) as count FROM Board";

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

    public BoardEntity getBoard(int num) {
        BoardEntity Board = null;

        String sql = "SELECT * FROM Board WHERE num = ?";

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
            pst.setInt(1, num);

            rs = pst.executeQuery();


            while (rs.next()) {
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                Date date = rs.getDate("date");
                String content = rs.getString("content");
                int like_count = rs.getInt("like_count");
                String file = rs.getString("file");

                Board = new BoardEntity(
                        title
                        , writer
                        , date
                        , content
                        , like_count
                        , file
                );
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
        return Board;
    }

    public int delBoardAll(int[] ids) {
        int result = 0;

        String params = "";

        for (int i=0; i<ids.length; i++) {
            params += ids[i];
            if(i<ids.length-1)
                params += ",";
        }

        String sql = "DELETE FROM BOARD WHERE NUM IN ("+params+")";

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
