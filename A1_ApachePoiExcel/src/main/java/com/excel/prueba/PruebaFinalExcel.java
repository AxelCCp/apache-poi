package com.excel.prueba;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PruebaFinalExcel {

	public static void main(String[] args) {
		
		List<Cliente> listadoClientes = PruebaFinalExcel.obtenerListado();
		Field[]campos = Cliente.class.getDeclaredFields();
		
		XSSFWorkbook libro = new XSSFWorkbook();
		XSSFSheet hoja = libro.createSheet("Clientes");
		
		XSSFRow fila = null; 
		XSSFCell celda = null;
		
		for(int i=0; i <listadoClientes.size(); i++) {
			
			//se genera la cabecera
			if(i == 0) {
				fila = hoja.createRow(0);
				
				for(int j=0; j<campos.length; j++) {
					celda = fila.createCell(j);
					celda.setCellValue(campos[j].getName());
				}
			}
			
			Cliente cliente = listadoClientes.get(i);
			List<Object>atributos = cliente.obtenerAtributos();
			fila = hoja.createRow(i+1); 
			
			for (int a = 0; a < atributos.size(); a++) {
				
				celda = fila.createCell(a);
				
				if(atributos.get(a) instanceof Long) {
					celda.setCellValue((Long) atributos.get(a));
				}
				if(atributos.get(a) instanceof String) {
					celda.setCellValue((String) atributos.get(a));
				}
				if(atributos.get(a) instanceof LocalDate) {
					celda.setCellValue((LocalDate) atributos.get(a));
				}
				
				hoja.autoSizeColumn(a);									//se adapta automaticamente el ancho de la columna. 
			}
		}
		
		try {
			OutputStream output = new FileOutputStream("pruebaFinal.xlsx");
			libro.write(output);
			libro.close();
			output.close();
			System.out.println("zzzzzzzzzzzzzzzz");
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error al crear el documento");
		}
	}

	
	
	public static List<Cliente>obtenerListado(){
		List<Cliente> listadoClientes = new ArrayList<>();
		listadoClientes.add(new Cliente(1L, "Rey", "Pilaf", "12345", "pilaf@zzz.jp", LocalDate.of(1998, 11, 14)));
		listadoClientes.add(new Cliente(2L, "aaa", "aaa2", "12346", "aaa@zzz.jp", LocalDate.of(1990, 10, 01)));
		listadoClientes.add(new Cliente(3L, "bbb", "ccc", "12347", "bbbf@zzz.jp", LocalDate.of(1998, 7, 02)));
		listadoClientes.add(new Cliente(4L, "ddd", "eee", "12348", "cccf@zzz.jp", LocalDate.of(1998, 5, 05)));
		listadoClientes.add(new Cliente(5L, "fff", "ggg", "12349", "fff@zzz.jp", LocalDate.of(1998, 8, 10)));
		listadoClientes.add(new Cliente(6L, "hhhh", "iii", "12310", "hh@zzz.jp", LocalDate.of(1998, 9, 16)));
		return listadoClientes;
	}
}
