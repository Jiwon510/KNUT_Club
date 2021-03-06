package controller;

import entity.NoticeEntity;
import service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NoticeController", value = "/notice")
public class NoticeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String field_ = request.getParameter("search");
        String query_ = request.getParameter("word");
        String page_ = request.getParameter("p");

        String field = "title";
        if (field_ != null && !field_.equals(""))
            field = field_;

        String query = "";
        if (query_ != null && !query_.equals(""))
            query = query_;

        int page = 1;
        if (page_ != null && !page_.equals(""))
            page = Integer.parseInt(page_);

        NoticeService service = new NoticeService();
        List<NoticeEntity> list = service.getNoticeList(field, query, page);
        int count = service.getNoticeCount(field, query);

        request.setAttribute("list", list);
        request.setAttribute("count", count);

        request.getRequestDispatcher("/view/notice/notice.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] delIds = request.getParameterValues("del_id");

        NoticeService service = new NoticeService();
        int[] ids = new int[delIds.length];
        for(int i=0; i<delIds.length; i++)
            ids[i] = Integer.parseInt(delIds[i]);

        int result = service.delNoticeAll(ids);

        response.sendRedirect("/view/notice/notice.jsp");
    }
}
