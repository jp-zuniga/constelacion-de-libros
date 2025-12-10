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
public
class Sala extends BaseEntity {
    @Column(
        length = 10, nullable = false, unique = true
    )
    @Required
    private String nombre;

    public
    String getNombre() {
        return nombre;
    }

    @Override
    public
    String toString() {
        return "Sala{" + "nombre='" + nombre + '\'' + '}';
    }
}
