package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Seccion extends BaseEntity {
    @Column(
        length = 10,
        nullable = false,
        unique = true
    )
    @Required
    private String nombre;

    @Override
    public String toString() {
        return "Seccion{" + "nombre='" + nombre + '\'' + '}';
    }
}
