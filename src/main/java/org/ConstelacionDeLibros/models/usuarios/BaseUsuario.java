package org.ConstelacionDeLibros.models.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;
import org.openxava.annotations.Stereotype;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public
class BaseUsuario extends BaseEntity {
    @Column(length = 20, nullable = false, unique = true)
    @Required
    private String cedula;

    @Column(length = 80, nullable = false)
    @Required
    private String nombres;

    @Column(length = 80, nullable = false)
    @Required
    private String apellidos;

    @Column(length = 15)
    @Stereotype("TELEPHONE")
    private String telefono;

    @Column(length = 100)
    @Stereotype("EMAIL")
    private String email;

    public
    String getNombres() {
        return nombres;
    }

    public
    String getApellidos() {
        return apellidos;
    }

    @Override
    public
    String toString() {
        return "Usuario{" + "cedula='" + cedula + '\'' + ", nombres='" + nombres
               + '\'' + ", apellidos='" + apellidos + '\'' + ", telefono='"
               + telefono + '\'' + ", email='" + email + '\'' + '}';
    }
}
