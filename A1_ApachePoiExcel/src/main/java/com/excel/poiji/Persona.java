package com.excel.poiji;

import com.poiji.annotation.ExcelCell;
//import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;

//@ExcelSheet("Hoja1")			//FORMA 1
public class Persona {

	public Persona() {
	}
	
	public Persona(Long id, String documento, String nombre, String apellido, String ciudad, String fechaNacimiento) {
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", ciudad=" + ciudad + ", fechaNacimiento=" + fechaNacimiento + "]";
	}




	//@ExcelCellName(value="id", mandatory=true)  para identificar las columnas tambn se puede usar el nombre de la columna. // mandatory obliga q el la celda tenga un valor.
	@ExcelCell(0)												// 0 : indice de columna.
	private Long id;
	@ExcelCell(1)
	private String documento;
	@ExcelCell(2)
	private String nombre;
	@ExcelCell(3)
	private String apellido;
	@ExcelCell(4)
	private String ciudad;
	@ExcelCell(5)
	private String fechaNacimiento;
	
	
}
