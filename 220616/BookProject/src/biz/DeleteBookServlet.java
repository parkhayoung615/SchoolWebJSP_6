package biz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public DeleteBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String isbn = request.getParameter("isbn");
		BookDAO dao = new BookDAO();
		int n = dao.deleteBookData(isbn);
		
		if(n<=0) {
			out.println("<script>alert('도서 삭제에 실패함'); </script>");
		}
		
		response.sendRedirect("/listBook");
	}

}
