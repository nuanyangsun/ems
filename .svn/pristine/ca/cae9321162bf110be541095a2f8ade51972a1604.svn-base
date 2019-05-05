package com.lx;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

public class POIExcelDemo3 {

	public static void main(String[] args) throws IOException, SQLException {
		
		HSSFWorkbook workBook = new HSSFWorkbook(); //创建excel文件
		HSSFSheet sheet = workBook.createSheet(); //创建工作表
		
		sheet.setColumnWidth(0, 20*256);
		sheet.setColumnWidth(1, 20*256);
		sheet.setColumnWidth(2, 20*256);
		
		//标题样式
		HSSFCellStyle titleStyle = workBook.createCellStyle();
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //水平居中
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont titleFont =  workBook.createFont(); //字体
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //加粗
		titleFont.setFontHeightInPoints((short)14);  //字号
		titleStyle.setFont(titleFont);               //标题使用字体样式
		//正文样式
		HSSFCellStyle contentStyle = workBook.createCellStyle();
		HSSFFont contentFont = workBook.createFont(); //字体
		contentFont.setFontHeightInPoints((short)12);
		contentStyle.setFont(contentFont);
		contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//边框
		contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); //居中
		contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		HSSFRow titleRow = sheet.createRow(0);    //创建标题行
		HSSFCell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("商品代码详情");
		titleCell.setCellStyle(titleStyle);     //单元格样式
		CellRangeAddress address = new CellRangeAddress(0, 0, 0, 2);
		sheet.addMergedRegion(address);
		titleRow.setHeightInPoints(30); //行高
		
		
		HSSFRow row2 = sheet.createRow(1);      //中间有一个空白行
		row2.setHeightInPoints(20);
		HSSFCell cell0 = row2.createCell(0);
		cell0.setCellValue("商品编码");
		cell0.setCellStyle(contentStyle);
		HSSFCell cell1 = row2.createCell(1);
		cell1.setCellValue("商品名称");
		cell1.setCellStyle(contentStyle);
		HSSFCell cell2 = row2.createCell(2);
		cell2.setCellValue("规格");
		cell2.setCellStyle(contentStyle);
		
		//获取数据
		Connection connection = CommonUtil.getConnection();
		Statement statement = connection.createStatement();
		String sql = "select mtrcd,mtrname,specs from mtrcd_material_code where mtrcd like 'AA%' and  rownum<=10";
		ResultSet rs = statement.executeQuery(sql);
		int flag = 2;
		while(rs.next()){
			HSSFRow datarow = sheet.createRow(flag);
			datarow.setHeightInPoints(20);
			HSSFCell datacell1 = datarow.createCell(0);
			datacell1.setCellValue(rs.getString(1));
			datacell1.setCellStyle(contentStyle);
			
			HSSFCell datacell2 = datarow.createCell(1);
			datacell2.setCellValue(rs.getString(2));
			datacell2.setCellStyle(contentStyle);
			
			HSSFCell datacell3 = datarow.createCell(2);
			datacell3.setCellValue(rs.getString(3));
			datacell3.setCellStyle(contentStyle);
			
			flag++;
		}
		
		String path = "e:\\demo.xls";
		FileOutputStream out = new FileOutputStream(path);
		workBook.write(out);	//保存单元格
		out.close();
		System.out.println("运行成功");
	}
}
