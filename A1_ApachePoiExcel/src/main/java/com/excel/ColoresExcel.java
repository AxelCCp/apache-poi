package com.excel;

import java.io.FileOutputStream;

import org.apache.commons.codec.binary.Hex;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.OutputStream;

public class ColoresExcel {
	
	public static void main(String[]args) {
		
		/*colores*/
		XSSFColor verdeClaro = crearColor("62F744");
		
		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja = libro.createSheet();
		XSSFRow fila = hoja.createRow(1);
		XSSFCell celda = fila.createCell(1);
		XSSFCellStyle estiloCelda = libro.createCellStyle();
		
		XSSFCell celda2 = fila.createCell(2);
		XSSFCellStyle estiloCelda2 = libro.createCellStyle();
		
		//configuracion de estilos
		estiloCelda.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		estiloCelda.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		estiloCelda2.setFillForegroundColor(verdeClaro);
		estiloCelda2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		//configuracion de celda
		celda.setCellValue("color predeterminado");
		celda.setCellStyle(estiloCelda);
		celda2.setCellValue("color personalizado");
		celda2.setCellStyle(estiloCelda2);
		
		
		//configuracion de hoja
		hoja.autoSizeColumn(1);
		hoja.autoSizeColumn(2);
		
		try {
			OutputStream output = new FileOutputStream("ColoresExcel.xlsx");
			libro.write(output);
			libro.close();
			output.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-------------");
	}
	
	
	public static XSSFColor crearColor(String colorHexadecimal) {
		try {
			byte[] rgb = Hex.decodeHex(colorHexadecimal);
			return new XSSFColor(rgb);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error al crear el color");
		}
	}
	
}
