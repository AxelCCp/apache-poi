package com.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrincipalExcel {

	public static void main(String[] args) {
		
		//Workbook libro2 = new HSSFWorkbook();													//archivo con extension .xls
		
		Workbook libro = new XSSFWorkbook();													//archivo con extension .xlsx
		Sheet hoja1 = libro.createSheet("Personas");
		Sheet hoja2 = libro.createSheet("Contactos");
		
		try {
			OutputStream output = new FileOutputStream("UnProgramadorNace.xlsx");
			libro.write(output);																//crea el libro
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
