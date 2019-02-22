

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lw.pj5.beans.Goods;
import com.lw.pj5.dao.GoodsDAO;

/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet(name = "addGoods", urlPatterns = { "/admin/addGoods" })
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGoodsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		Goods goods=(Goods) session.getAttribute("goods");
		GoodsDAO goodsDao=new GoodsDAO();
		String info=goodsDao.addGoods(goods).trim();
		if(info.equals("success")){
			response.sendRedirect("addGoodsOK.jsp");
		}else if(info.equals("fail")){
			response.sendRedirect("addGoodsFail.jsp");
		}
	}

}
