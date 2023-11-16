package com.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrincipalExcel {

	public static void main(String[] args) {
		
		//Workbook libro2 = new HSSFWorkbook();													//archivo con extension .xls
		
		Workbook libro = new XSSFWorkbook();													//archivo con extension .xlsx
		Sheet hoja1 = libro.createSheet("Personas");
		//Sheet hoja2 = libro.createSheet("Contactos");
		
		Row fila = hoja1.createRow(1);
		Cell celda = fila.createCell(1);
		celda.setCellValue("Hola");
		
		Row fila2 = hoja1.createRow(3);
		Cell celda2 = fila2.createCell(5);
		celda.setCellValue("xxxxx");
		
		
		try {
			OutputStream output = new FileOutputStream("UnProgramadorNace.xlsx");
			libro.write(output);																//crea el libro
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
