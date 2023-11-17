package com.excel.lectura;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLecturaColumna {
	
	public static void main(String[] args) {
		
		
		File archivo = new File("Datos.xlsx");
		try {
			InputStream input = new FileInputStream(archivo);
			XSSFWorkbook libro = new XSSFWorkbook(input);
			XSSFSheet hoja = libro.getSheet("Columna");
			
			//Row fila = hoja.getRow(1);														//trae el registro de una fila.
			Iterator<Row>filas = hoja.rowIterator();											//almacena en un iterator los registros de la columna
				
			Cell columna = null;
			
			while(filas.hasNext()) {
				columna = filas.next().getCell(0);												//con 0 obtiene los datos de la columna A.
				System.out.println(columna.getStringCellValue());
			}
			
			input.close();
			libro.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
