package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class EstanteFila extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_estante", nullable = false
    )
    @Required
    private Estante estante;

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
    Estante getEstante() {
        return estante;
    }

    public
    Integer getNumero() {
        return numero;
    }

    @Override
    public
    String toString() {
        return "EstanteFila{" + "estante=" + estante + ", numero=" + numero
               + '}';
    }
}
