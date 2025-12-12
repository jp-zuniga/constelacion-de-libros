package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class Sala extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @Column(
        length = 10, nullable = false, unique = true
    )
    @Required
    private String nombre;

    @Override
    public
    Auditoria getAuditoria() {
        return auditoria;
    }

    @Override
    public
    void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

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
