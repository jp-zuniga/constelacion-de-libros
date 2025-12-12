package org.ConstelacionDeLibros.models.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.openxava.annotations.Tab;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Tab(properties = "cedula, nombres, apellidos, email, cargo")
public
class Empleado extends BaseUsuario implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @Column(length = 30)
    private String cargo;

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

    @Override
    public
    String toString() {
        return "Empleado{" + "cargo='" + cargo + '\'' + '}';
    }
}
