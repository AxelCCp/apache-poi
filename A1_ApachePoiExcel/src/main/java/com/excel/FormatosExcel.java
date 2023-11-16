package com.excel;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormatosExcel {

	public static void main(String[] args) {
		
System.out.println("formatos");
		
		//crear libro
		XSSFWorkbook libro = new XSSFWorkbook();
		//crear hoja
		XSSFSheet hoja = libro.createSheet();
		//crear fila
		XSSFRow fila = hoja.createRow(1);
		
		//crear celdas
		XSSFCell celda = fila.createCell(1);
		XSSFCellStyle estiloCelda = libro.createCellStyle();
	
		
		//configuracion de estilos
		//estiloCelda.setDataFormat(libro.createDataFormat().getFormat("dd/MM/yyyy")); //el libro provee un objeto para la creación de los formatos de nuestra celda.
		estiloCelda.setDataFormat(libro.createDataFormat().getFormat("dd/MM/yyyy HH:mm:ss"));
		
		//configuracion de celda.
		//celda.setCellValue(LocalDate.now());
		celda.setCellValue(LocalDateTime.now());
		celda.setCellStyle(estiloCelda);
		
		//configuracion de hoja
		
		
		
		try {
			OutputStream output = new FileOutputStream("formatos.xlsx");
			libro.write(output);
			libro.close();
			output.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

}
