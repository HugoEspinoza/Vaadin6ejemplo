package com.empresa.proyecto.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_ESTADO_CIVIL")
public class EstadoCivil implements Serializable{

	private static final long serialVersionUID = -2747991079803962080L;

	@Id
    @Column(name = "ID", unique = true, nullable = false, precision = 5, scale = 0)
	private Integer id;
    
    @Column(name = "DESCRIPCION", nullable = true, length = 10)
	private String descripcion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoCivil other = (EstadoCivil) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstadoCivil [id=").append(id).append(", descripcion=")
				.append(descripcion).append("]");
		return builder.toString();
	}
    
}
