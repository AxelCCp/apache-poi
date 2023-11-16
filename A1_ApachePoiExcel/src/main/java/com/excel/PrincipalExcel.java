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
														
		Workbook libro = new XSSFWorkbook();													
		
		Sheet hoja = libro.createSheet("Personas");
		
		Row cabecera = hoja.createRow(2);
		
		Cell nombre = cabecera.createCell(1);
		Cell edad = cabecera.createCell(2);
		Cell ciudad = cabecera.createCell(3);
		
		nombre.setCellValue("Nombre");
		edad.setCellValue("Edad");
		ciudad.setCellValue("Ciudad");
		
		Row registro1 = hoja.createRow(3);
		
		Cell nombreRegistro1 = registro1.createCell(1);
		Cell edadRegistro1 = registro1.createCell(2);
		Cell ciudadRegistro1 = registro1.createCell(3);
			
		nombreRegistro1.setCellValue("Santiago");
		edadRegistro1.setCellValue("23");
		ciudadRegistro1.setCellValue("Medellin");
		
		Row registro2 = hoja.createRow(4);
		
		Cell nombreRegistro2 = registro2.createCell(1);
		Cell edadRegistro2 = registro2.createCell(2);
		Cell ciudadRegistro2 = registro2.createCell(3);
		
		nombreRegistro2.setCellValue("Anyi");
		edadRegistro2.setCellValue("25");
		ciudadRegistro2.setCellValue("Medellin .. ");
		try {
			OutputStream output = new FileOutputStream("UnProgramadorNace.xlsx");
			libro.write(output);	
			libro.close();
			output.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
