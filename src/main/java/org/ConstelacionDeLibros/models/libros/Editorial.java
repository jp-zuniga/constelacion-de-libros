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
public class Editorial extends BaseEntity {
    @Column(length = 100, nullable = false, unique = true)
    @Required
    private String nombre;

    @Override
    public String toString() {
        return "Editorial{" + "nombre='" + nombre + '\'' + '}';
    }
}
