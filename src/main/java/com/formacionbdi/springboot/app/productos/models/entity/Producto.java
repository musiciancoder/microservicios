package com.formacionbdi.springboot.app.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	@Id //q tenga llave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) //q la llave primaria sea autoincremental
	private Long id;
	private String nombre;
	private Double precio;



	@Transient //para indicar que no esta mapeado a nada en la BBDD
	private Integer port;
	
	@Column(name="create_at") //nombre de columna SIEMPRE CON MINUSCULA
	@Temporal(TemporalType.DATE) //con esto pasa la fecha desde java.util.date a java.sql.date
	private Date createAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Integer getPort() {return port;}
	public void setPort(Integer port) {this.port = port; }
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1285454306356845809L;

}
