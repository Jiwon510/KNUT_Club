package controller;

import service.BoardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BoardController", value = "/board")
public class BoardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String field_ = request.getParameter("search");
        String query_ = request.getParameter("word");
        String page_ = request.getParameter("p");

        String field = "title";
        if(field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if(query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if(page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        BoardService service = new BoardService();
        List<Board> list = service.getBoardList(field, query, page);
        int count = service.getBoardCount(field, query);

        request.setAttribute("list", list);
        request.setAttribute("count", count);

        request.getRequestDispatcher("/VIEW/board/board.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] delIds = request.getParameterValues("del_id");

        BoardService service = new BoardService();
        int[] ids = new int[delIds.length];
        for(int i=0; i<delIds.length; i++)
            ids[i] = Integer.parseInt(delIds[i]);

        int result = service.delBoardAll(ids);

        response.sendRedirect("/VIEW/board/board");
    }
}
