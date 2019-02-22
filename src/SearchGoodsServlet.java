

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lw.pj5.beans.Goods;
import com.lw.pj5.dao.GoodsDAO;

/**
 * Servlet implementation class SearchGoodsServlet
 */
@WebServlet(
		name = "searchGoods", 
		urlPatterns = { 
				"/searchGoods", 
				"/admin/searchGoods"
		})
public class SearchGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchGoodsServlet() {
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
		String searchType=request.getParameter("searchType").trim();
		GoodsDAO  goodsDao=new GoodsDAO();
		List<Goods>someGoods=null;
		StringBuffer sqlBuffer=new StringBuffer("select * from goods where ");
		if(searchType.equals("按条件查询商品")){
			String name=request.getParameter("name").trim();
			if(name==null|| name.equals(" ")){
				sqlBuffer.append(true);
			}else{
				sqlBuffer.append("name like '%" +name+"%'");
			}
			String minprice=request.getParameter("minprice").trim();
			String maxprice=request.getParameter("maxprice").trim();
			if(minprice==null || maxprice==null || minprice.equals(" ") || maxprice.equals("")){
				sqlBuffer.append(" and " +true);
			}else{
				sqlBuffer.append("and price between"+minprice+" and "+maxprice);
			}
			String sql=sqlBuffer.toString();
			System.out.println(sql);
			someGoods=goodsDao.queryGoodsBySQL(sql);
		}else if(searchType.equals("查询所有的商品")){
			System.out.println("searchType");
			someGoods=goodsDao.queryAllGoods();
		}
		request.setAttribute("someGoods", someGoods);
		request.getRequestDispatcher("queryGoods.jsp").forward(request, response);
	}

}
