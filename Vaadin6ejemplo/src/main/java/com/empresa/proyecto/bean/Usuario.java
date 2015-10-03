package com.empresa.proyecto.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable  {

	private static final long serialVersionUID = 6144757844625295746L;

	@Id
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Integer id;
    
    @Column(name = "NOMBRE", nullable = true, length = 45)
    private String nombre;
    
    
    @Column(name = "USERNAME", nullable = true, length = 20)
    private String username;
    
    @Column(name = "CLAVE", nullable = true, length = 10)
    private String clave;

    
    public Usuario(){}
    
	public Usuario(String nombre, String username) {
		super();
		this.nombre = nombre;
		this.username = username;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [id=").append(id).append(", nombre=")
				.append(nombre)
				.append(", username=").append(username).append(", clave=")
				.append(clave).append("]");
		return builder.toString();
	}
    
}
