package org.ConstelacionDeLibros.models.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Empleado extends BaseEntity {

    @Column(length = 80, nullable = false)
    @Required
    private String nombres;

    @Column(length = 80, nullable = false)
    @Required
    private String apellidos;

    @Column(length = 100, nullable = false, unique = true)
    @Stereotype("EMAIL")
    @Required
    private String email;

    @Column(length = 20)
    @Stereotype("TELEPHONE")
    private String telefono;

    @Column(length = 30)
    private String cargo;

    @Override
    public String toString() {
        return "Empleado{" +
                "nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
