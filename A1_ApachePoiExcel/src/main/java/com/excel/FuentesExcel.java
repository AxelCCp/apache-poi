package com.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FuentesExcel {

	public static void main(String[] args) {
		System.out.println("kajhdkajhsd");
		// TODO Auto-generated method stub
		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja = libro.createSheet();
		XSSFRow fila = hoja.createRow(1);
		XSSFCell celda = fila.createCell(1);
		XSSFCellStyle estiloCelda = libro.createCellStyle();
		
		XSSFFont fuente = libro.createFont();
		fuente.setFontName("Franklin Gothic Book");
		fuente.setBold(true);
		fuente.setItalic(true);
		fuente.setFontHeightInPoints((short) 14);
		fuente.setColor(IndexedColors.RED.getIndex());
		fuente.setUnderline(FontUnderline.SINGLE);
		
		//configuracion de estilos
		estiloCelda.setFont(fuente);
		estiloCelda.setAlignment(HorizontalAlignment.CENTER);
		estiloCelda.setVerticalAlignment(VerticalAlignment.CENTER);
		
		//configuracion de celda.
		celda.setCellValue("Apache poi - fuentes");
		celda.setCellStyle(estiloCelda);
		
		//configuracion de hoja
		hoja.autoSizeColumn(1);
		
		try {
			OutputStream output = new FileOutputStream("FuentesExcel.xlsx");
			libro.write(output);
			libro.close();
			output.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

}
