package com.empresa.proyecto.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TB_OPCION")
public class Opcion implements Serializable{

	private static final long serialVersionUID = 5407291873747317969L;

	@Id
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	private Integer id;

    @Column(name = "IDUSUARIO", unique = true, nullable = false, precision = 5, scale = 0)
	private Integer idUsuario;

    @Column(name = "DESCRIPCION", nullable = true, length = 50)
	private String descripcion;

    @Column(name = "TIPO", nullable = true, length = 50)
	private String tipo;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
