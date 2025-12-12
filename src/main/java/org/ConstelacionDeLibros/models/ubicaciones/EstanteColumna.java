package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public
class EstanteColumna extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_fila", nullable = false
    )
    @Required
    private EstanteFila fila;

    @Column(nullable = false)
    @Required
    private Integer numero;

    public
    Auditoria getAuditoria() {
        return auditoria;
    }

    public
    void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public
    EstanteFila getFila() {
        return fila;
    }

    public
    Integer getNumero() {
        return numero;
    }

    @Override
    public
    String toString() {
        return (
                   fila != null ? fila.getEstante().getNombre() + " - Fila "
                                  + fila.getNumero() : ""
               ) + " - Col " + numero;
    }
}
