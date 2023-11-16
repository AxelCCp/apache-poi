package com.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EstilosExcel {
	
	public static void main (String[]excel) {
		
		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja = libro.createSheet();
		XSSFRow fila = hoja.createRow(1);	
		XSSFCell celda = fila.createCell(1);
		
		XSSFCellStyle estiloCelda = libro.createCellStyle();
		
		/*configuracion de estilos*/
		estiloCelda.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		estiloCelda.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		estiloCelda.setBorderBottom(BorderStyle.THIN);
		estiloCelda.setBorderTop(BorderStyle.THIN);
		estiloCelda.setBorderLeft(BorderStyle.THIN);
		estiloCelda.setBorderRight(BorderStyle.THIN);
		
		/*configuracion de celda*/
		celda.setCellValue("Estilos con apache poi");
		celda.setCellStyle(estiloCelda);
		
		hoja.autoSizeColumn(1);
		
		
		try {
			OutputStream output = new FileOutputStream("EstilosExcel.xlsx");
			libro.write(output);
			libro.close();
			output.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("...........");
	}

	
}
