package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class EstadoEjemplar extends BaseEntity {
    @Column(length = 30, nullable = false, unique = true)
    @Required
    private String nombre;

    @Column(length = 120, nullable = true)
    private String descripcion;

    @Override
    public String toString() {
        return "EstadoEjemplar{" + "nombre='" + nombre + '\'' +
               ", descripcion='" + descripcion + '\'' + '}';
    }
}
