package com.lx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class POIExcelDemo4 {

	public static void main(String[] args) throws Exception {
		String title = "商品代码表";
		String[] name = {"序号","商品编码","商品名称","规格"};
		//获取数据
		Connection connection = CommonUtil.getConnection();
		Statement statement = connection.createStatement();
		String sql = "select seqno,mtrcd,mtrname,specs from mtrcd_material_code where mtrcd like 'AA%' and  rownum<=30";
		ResultSet rs = statement.executeQuery(sql);
		
		CommonUtil.exportExcel(title,name,rs);
		
	}
}
