package com.empresa.proyecto.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_EMPLEADO")
public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 242256936513431703L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
    private Integer id;
    
    @Column(name = "NOMBRE", nullable = false, length = 25)
    private String nombre;
    
    @Column(name = "APELLIDO", nullable = false, length = 25)
    private String apellido;
    
    @Column(name = "EMAIL", nullable = false, length = 25)
    private String email;
    
	@ManyToOne
	@JoinColumn(name="ID_ESTADOCIVIL", nullable=false)
	private EstadoCivil estadoCivil;

    @Column(name = "ESTADO", nullable = true, length = 2)
    private String estado;

    
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Empleado [id=").append(id).append(", nombre=")
				.append(nombre).append(", apellido=").append(apellido)
				.append(", email=").append(email).append(", estadoCivil=")
				.append(estadoCivil).append(", estado=").append(estado)
				.append("]");
		return builder.toString();
	}
	
}
