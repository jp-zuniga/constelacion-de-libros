package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;

public enum EstadoEjemplar{
    DISPONIBLE,
    PRESTADO,
    EN_REPARACION,
    PERDIDO,
    BAJA
}
