/**
 * 
 */
package com.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RangosExcel {
	
	public static void main(String[]rangos) {
		
		System.out.println("rrrrrrr");
		
		//crear libro
		XSSFWorkbook libro = new XSSFWorkbook();
		//crear hoja
		XSSFSheet hoja = libro.createSheet();
		//crear fila
		XSSFRow fila = hoja.createRow(1);
		
		//crear celdas
		XSSFCell celda = fila.createCell(1);
		XSSFCellStyle estiloCelda = libro.createCellStyle();
		CellRangeAddress rango = new CellRangeAddress(2,7,1,5);
		
		//configuracion de estilos
		
		
		//configuracion de celda.
		
		
		//configuracion de hoja
		hoja.addMergedRegion(rango);
		
		
		try {
			OutputStream output = new FileOutputStream("rangos.xlsx");
			libro.write(output);
			libro.close();
			output.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
