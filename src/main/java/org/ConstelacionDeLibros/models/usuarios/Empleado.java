package org.ConstelacionDeLibros.models.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.openxava.annotations.Tab;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Tab(properties = "cedula, nombres, apellidos, email, cargo")
public
class Empleado extends BaseUsuario {
    @Column(length = 30)
    private String cargo;

    @Override
    public
    String toString() {
        return "Empleado{" + "cargo='" + cargo + '\'' + '}';
    }
}
