package com.shtoone.qms.util;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.fr.third.org.apache.poi.hssf.util.HSSFColor;
import com.shtoone.qms.entity.bhz.TemperaturedataView;

import java.io.File;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Workbook;
import jxl.format.Border;



import jxl.write.Label;


import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;



public class HntExcelUtil {
	static Log logger = LogFactory.getLog(HntExcelUtil.class);	
	

	
	public static void importcnfxExcel(String modelName,String excelName,
			String shijian,String header,List<String> dataList){
	
		System.out.println(modelName);
		try{
			//Excel获得文件
			Workbook wb=Workbook.getWorkbook(new File(modelName)); 
			//打开一个文件的副本，并且指定数据写回到原文件
			WritableWorkbook book=Workbook.createWorkbook(new File(excelName), wb);
			WritableSheet sheet = book.getSheet(0);
			/*
			if (null != bhzmc && bhzmc.equalsIgnoreCase("-请选择拌和机-")) {
				bhzmc = "";
			}
			*/
			String bhzmc = "";
			Label a= (Label)sheet.getWritableCell(0, 1);
			a.setString(String.format("%s产能分析表", bhzmc));
			a = (Label)sheet.getWritableCell(0, 2);
			a.setString(shijian);
			a = (Label)sheet.getWritableCell(1, 4);
			a.setString(header);
			WritableFont font= new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);
			WritableCellFormat cellFormat2 = new WritableCellFormat(font); 
			cellFormat2.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);
			 //把水平对齐方式指定为居中 
			cellFormat2.setAlignment(jxl.format.Alignment.CENTRE); 
			//把垂直对齐方式指定为居中 
			cellFormat2.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			//设置自动换行
			cellFormat2.setWrap(true);
			jxl.write.NumberFormat format = new jxl.write.NumberFormat("#"); 
			jxl.write.WritableCellFormat wcf = new jxl.write.WritableCellFormat(format);
			
			for(int j=0;j<dataList.size();j++){
				String data=(String)dataList.get(j);//获得一条数据
				String [] dataArray=data.split("\\&\\^\\&");//分解数据
				for(int k=0;k<dataArray.length;k++){
					if (StringUtil.Null2Blank(dataArray[k]).length() > 0) {
						Cell cell = sheet.getCell(k,j+5);
						if (cell.getType()==CellType.NUMBER) {
							   jxl.write.Number nb=(jxl.write.Number) cell;
						       nb.setValue(Double.parseDouble(dataArray[k]));
						} else {						
							jxl.write.Number nb=new jxl.write.Number(k,j+5,Double.parseDouble(dataArray[k]),wcf);
							nb.setCellFormat(cellFormat2); 
							sheet.addCell(nb);
						}
					} else {
						Cell cell = sheet.getCell(k,j+5);
						if (cell.getType()==CellType.LABEL) {
						       Label label=(Label) cell;
						       label.setString(dataArray[k]);
						} else {						
							Label label=new Label(k,j+5,dataArray[k]);
							label.setCellFormat(cellFormat2); 
							sheet.addCell(label);
						}
					}				
					
				}
			}
			//写入数据并关闭文件 
			book.write();
			book.close();
			wb.close();
		}catch(Exception e){
		}
	}
	
	

	public static void importsmstjExcel(String modelName,String excelName,
			String shijian,List<String> dataList){
		try{
			//Excel获得文件
			Workbook wb=Workbook.getWorkbook(new File(modelName)); 
			//打开一个文件的副本，并且指定数据写回到原文件
			WritableWorkbook book=Workbook.createWorkbook(new File(excelName), wb);
			WritableSheet sheet = book.getSheet(0);
			/*
			if (null != bhzmc && bhzmc.equalsIgnoreCase("-请选择拌和站-")) {
				bhzmc = "";
			}
			*/
//			Label a= (Label)sheet.getWritableCell(0, 1);
//			a.setString(String.format("%s拌和站超标统计表", ""));
//			a = (Label)sheet.getWritableCell(0, 2);
//			a.setString(shijian);
	
			WritableFont font= new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.NO_BOLD);
			WritableCellFormat cellFormat2 = new WritableCellFormat(font); 
			cellFormat2.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);
			 //把水平对齐方式指定为居中 
			cellFormat2.setAlignment(jxl.format.Alignment.CENTRE); 
			//把垂直对齐方式指定为居中 
			cellFormat2.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			//设置自动换行
			cellFormat2.setWrap(true);
			jxl.write.NumberFormat format = new jxl.write.NumberFormat("#"); 
			jxl.write.WritableCellFormat wcf = new jxl.write.WritableCellFormat(format);
			
			jxl.write.NumberFormat format1 = new jxl.write.NumberFormat("###,##0.00"); 
			WritableCellFormat cellFormat1 = new WritableCellFormat(font,format1);
			cellFormat1.setBorder(Border.ALL, jxl.format.BorderLineStyle.THIN);
			 //把水平对齐方式指定为居中 
			cellFormat1.setAlignment(jxl.format.Alignment.CENTRE); 
			//把垂直对齐方式指定为居中 
			cellFormat1.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			//设置自动换行
			cellFormat1.setWrap(true);
			
			for(int j=0;j<dataList.size();j++){
				String data=(String)dataList.get(j);//获得一条数据
				String [] dataArray=data.split("\\&\\^\\&");//分解数据
				for(int k=0;k<dataArray.length;k++){
						if (k>1 && StringUtil.Null2Blank(dataArray[k]).length() > 0) {
							Cell cell = sheet.getCell(k,j+2);
							if (cell.getType()==CellType.NUMBER) {
								   jxl.write.Number nb=(jxl.write.Number) cell;
							       nb.setValue(Double.parseDouble(dataArray[k]));
							} else {		
								if (k == 5) {
									jxl.write.Number nb=new jxl.write.Number(k,j+2,Double.parseDouble(dataArray[k]),wcf);
									nb.setCellFormat(cellFormat1); 
									sheet.addCell(nb);
								} else {
									jxl.write.Number nb=new jxl.write.Number(k,j+2,Double.parseDouble(dataArray[k]),wcf);
									nb.setCellFormat(cellFormat2); 
									sheet.addCell(nb);
								}
							}
						} else {
						//if (StringUtil.Null2Blank(dataArray[k]).length() > 0) {
							Cell cell = sheet.getCell(k,j+2);
							if (cell.getType()==CellType.LABEL) {
							       Label label=(Label) cell;
							       label.setString(dataArray[k]);
							} else {						
								Label label=new Label(k,j+2,dataArray[k]);
								label.setCellFormat(cellFormat2); 
								sheet.addCell(label);
							}
						//} 
					}
				}
			}
			//写入数据并关闭文件 
			book.write();
			book.close();
			wb.close();
		}catch(Exception e){
		}
	}
	public static HSSFWorkbook WSbaobiao(String sheetName,String[] headRow,List<TemperaturedataView> list){
		HSSFWorkbook bookWorkbook = new HSSFWorkbook();// 创建excel文件
		HSSFSheet sheet = bookWorkbook.createSheet(sheetName);
		HSSFCell cell;
		HSSFRow row;
		HSSFCellStyle style = bookWorkbook.createCellStyle();// 创建一个单元的样式
		// 背景色的设定
		style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		// 前景色的设定
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		// 填充模式
		//style.setFillPattern(HSSFCellStyle.FINE_DOTS);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置水平居中
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);// 上下居中
		// 设置上下左右边框样式
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置字体
		HSSFFont font = bookWorkbook.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 22);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		int rowint = 0;
		int titlerow1 = rowint++;
		row = sheet.createRow((short) titlerow1);
		for (int i = 0; i < headRow.length; i++) {
			cell = row.createCell((short) i);
			cell.setCellValue(headRow[i]);
			cell.setCellStyle(style);
		}
		int titlerow2 = rowint++;
		// 设置每列的宽度
		int k = 0;
		sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);

		for (int i = 0; i < list.size(); i++) {
			row=sheet.createRow((short)(titlerow2+i));
			TemperaturedataView view=list.get(i);
			int kk =0;
			cell=row.createCell((short)kk);
			cell.setCellStyle(style);
			cell.setCellValue(view.getBanhezhanminchen());
		   	
		   	kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getTmpshijian());
		   	
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getTmpdata());
		   	
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getWdfanwei());
		   	
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getShidudata());
		   	
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getSdfanwei());
		  }
		  return bookWorkbook;
	}
	
	
	public static HSSFWorkbook WSbaobiaoYHX(String sheetName,String[] headRow,List<TemperaturedataView> list){
		HSSFWorkbook bookWorkbook = new HSSFWorkbook();// 创建excel文件
		HSSFSheet sheet = bookWorkbook.createSheet(sheetName);
		HSSFCell cell;
		HSSFRow row;
		HSSFCellStyle style = bookWorkbook.createCellStyle();// 创建一个单元的样式
		// 背景色的设定
		style.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
		// 前景色的设定
		style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
		// 填充模式
		//style.setFillPattern(HSSFCellStyle.FINE_DOTS);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 设置水平居中
		style.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER);// 上下居中
		// 设置上下左右边框样式
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// 设置字体
		HSSFFont font = bookWorkbook.createFont();
		font.setFontName("黑体");
		font.setFontHeightInPoints((short) 22);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		int rowint = 0;
		int titlerow1 = rowint++;
		row = sheet.createRow((short) titlerow1);
		for (int i = 0; i < headRow.length; i++) {
			cell = row.createCell((short) i);
			cell.setCellValue(headRow[i]);
			cell.setCellStyle(style);
		}
		int titlerow2 = rowint++;
		// 设置每列的宽度
		int k = 0;
		sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);
		//sheet.setColumnWidth((short) k++, (short) 8000);
		sheet.setColumnWidth((short) k++, (short) 8000);
		//sheet.setColumnWidth((short) k++, (short) 8000);

		for (int i = 0; i < list.size(); i++) {
			row=sheet.createRow((short)(titlerow2+i));
			TemperaturedataView view=list.get(i);
			int kk =0;
			cell=row.createCell((short)kk);
			cell.setCellStyle(style);
			cell.setCellValue(view.getBanhezhanminchen());
		   	
		   	kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getTmpshijian());
		   	
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getTmpdata());
		   	
		   	/*
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getWdfanwei());
		   	*/
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getShidudata());
		   	/*
			kk++;
		   	cell=row.createCell((short)kk);
		   	cell.setCellStyle(style);
		   	cell.setCellValue(view.getSdfanwei());
		   	*/
		  }
		  return bookWorkbook;
	}
}

