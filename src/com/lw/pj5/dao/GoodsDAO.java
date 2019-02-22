package com.lw.pj5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.lw.pj5.beans.Goods;

public class GoodsDAO {
	private Connection conn = null;
	private String sql = null;
	private Statement st = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String info = null;

	public GoodsDAO() {
		conn = DBUtil.getConnection();
	}
	//添加商品
	public String addGoods(Goods goods){
		sql="insert into goods(id,name,number,price,depict) values(?,?,?,?,?)";
		int i=0;
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, goods.getId());
			ps.setString(2, goods.getName());
			ps.setInt(3, goods.getNumber());
			ps.setDouble(4, goods.getPrice());
			ps.setString(5, goods.getDepict());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(i==1){
			info="添加成功";
		}else{
			info="添加失败";
		}
		return info;
	} 
//删除商品
	public String delGoods(int id){
		sql="delete from goods where id=?";
		int i=0;
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(i==1){
			info="删除成功";
		}else{
			info="删除失败";
		}
		return info;
	}
	//修改商品
	public String updateGoods(Goods goods){
		sql="UPDATE goods SET name=?,number=?,price=? ,depict=? WHERE id=?";
		int i=0;
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, goods.getName());
			ps.setInt(2, goods.getNumber());
			ps.setDouble(3, goods.getPrice());
			ps.setString(4, goods.getDepict());
			ps.setInt(5, goods.getId());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(i==1){
			info="修改成功";
		}else{
			info="修改失败";
		}
		return info;
	}
	//查询所有商品
	public List<Goods> queryAllGoods(){
		sql="select *from goods";
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		List<Goods> allGoods=Collections.synchronizedList(new ArrayList<Goods>());
		try{
			while(rs.next()){
				Goods goods=new Goods();
				goods.setId(rs.getInt(1));
				goods.setName(rs.getString(2));
				goods.setNumber(rs.getInt(3));
				goods.setPrice(rs.getDouble(4));
				goods.setDepict(rs.getString(5));
				allGoods.add(goods);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return allGoods;
	}
	//按ID值查询指定的商品
	public Goods queryGoodsById(int id){
		sql="select* from goods where id=?";
		int i=0;
		Goods goods=null;
		try{
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			while(rs.next()){
				goods=new Goods();
				goods.setId(rs.getInt(1));
				goods.setName(rs.getString(2));
				goods.setNumber(rs.getInt(3));
				goods.setPrice(rs.getDouble(4));
				goods.setDepict(rs.getString(5));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return goods;
	}
	//按商品名称模糊查询
	public List<Goods> queryGoodsByName(String name){
		sql="select*from goods where name like?";
		try{
			ps=conn.prepareStatement(sql);
			ps.setString(1, "%"+name+"%");
			rs=ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		List<Goods>someGoods=Collections.synchronizedList(new ArrayList<Goods>());
		try{
			while(rs.next()){
				Goods goods=new Goods();
				goods.setId(rs.getInt(1));
				goods.setName(rs.getString(2));
				goods.setNumber(rs.getInt(3));
				goods.setPrice(rs.getDouble(4));
				goods.setDepict(rs.getString(5));
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return someGoods;
	}
	//按指定sql语句查询商品
	
	public List<Goods>queryGoodsBySQL(String sql){
		try{
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		List<Goods>someGoods=Collections.synchronizedList(new ArrayList<Goods>());
		try{
			while(rs.next()){
				Goods goods=new Goods();
				goods.setId(rs.getInt(1));
				goods.setName(rs.getString(2));
				goods.setNumber(rs.getInt(3));
				goods.setPrice(rs.getDouble(4));
				goods.setDepict(rs.getString(5));
				someGoods.add(goods);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return someGoods;
	}


}
