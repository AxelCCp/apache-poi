package com.excel.poiji;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;

public class PoijiMain {

	public static void main(String[] args) {
		
		//FORMA 1  --- funciona con @ExcelSheet("Hoja1") en la clase persona
		
		/*
		File archivo = new File("DatosPOIJI.xlsx");
		
		List<Persona> personas = Poiji.fromExcel(archivo, Persona.class);
		
		personas.forEach( p -> {
			System.out.println(p.toString());
		});
		*/
		
		
		//FORMA 2  --- funciona sin @ExcelSheet("Hoja1") en la clase persona
		File archivo = new File("DatosPOIJI.xlsx");
		
		PoijiOptions options = PoijiOptions.PoijiOptionsBuilder
											.settings()
											//.sheetIndex(0)											//se le pasa el indice de la sheet.
											.sheetName("Hoja1")                                         //se le pasa el nombre de la sheet.
											//.skip(5)													//se salta la cantidad de filas que se señalen con el parámetro.	
											//.limit(3)                                                 //solo lee los 1ros 3 registros.
											//.skip(3).limit(6)											//usar skip y limit como rango, desde el 3 imprime 6 registros en adelante.			
											.trimCellValue(true)  									    //elimina los espacios en blanco al inicio y al final de cada string.
											//.password("12345")           								//si es que el ´documento viene protegido.
											.build();					
		
		List<Persona> personas = Poiji.fromExcel(archivo, Persona.class, options);
		
		personas.forEach( p -> {
			System.out.println(p.toString());
		});
		
		
		
		
		System.out.println("----------------------------");
	}
	
}
