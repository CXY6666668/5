package com.lw.pj5.dao;

import java.util.List;

import org.junit.Test;

import com.lw.pj5.beans.Goods;
 
public class GoodsDAOTest {
	GoodsDAO goodsDao=new GoodsDAO();
@Test
	public void addGoodsTest(){
		Goods goods=new Goods();
		goods.setId(122);
		goods.setName("吉安特自行車");
		goods.setNumber(100);
		goods.setPrice(1500);
		goods.setDepict("自行車質量真好");
		//goodsDao.addGoods(goods);
		goodsDao.addGoods(goods);
	}
@Test
public void delGoodsTest(){
	System.out.println(goodsDao.delGoods(2006));
}
@Test
public void queryGoodsByIdTest(){
	Goods goods=goodsDao.queryGoodsById(1005);
	System.out.println(goods.getId());
	System.out.println(goods.getName());
	System.out.println(goods.getNumber());
	System.out.println(goods.getPrice());
	System.out.println(goods.getDepict());
}
@Test
public void updateGoodsTest(){
	Goods goods=goodsDao.queryGoodsById(1004);
	goods.setName("联想电脑");
	goods.setNumber(1000);
	goods.setPrice(5000);
	goods.setDepict("科技改变生活");
	System.out.println(goodsDao.updateGoods(goods));
	
}
@Test
public void queryAllGoodsTest(){
	List<Goods> allGoods=goodsDao.queryAllGoods();
	for(Goods goods:allGoods){
		System.out.println(goods.getId());
		System.out.println(goods.getName());
		System.out.println(goods.getNumber());
		System.out.println(goods.getPrice());
		System.out.println(goods.getDepict());
	}


}
@Test
public void queryGoodsByNameTest(){
	String name="电";
	List<Goods> someGoods=goodsDao.queryGoodsByName(name);
	for(Goods goods:someGoods){
		System.out.println(goods.getId());
		System.out.println(goods.getName());
		System.out.println(goods.getNumber());
		System.out.println(goods.getPrice());
		System.out.println(goods.getDepict());
	}
}
@Test
public void queryGoodsBySQLTest(){
	String sql="select * from goods where id=1003";
	List<Goods>someGoods=goodsDao.queryGoodsBySQL(sql);
	for(Goods goods:someGoods){
		System.out.println(goods.getId());
		System.out.println(goods.getName());
		System.out.println(goods.getNumber());
		System.out.println(goods.getPrice());
		System.out.println(goods.getDepict());
	}
}
}
