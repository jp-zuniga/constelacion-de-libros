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
class Estante extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @Column(
        length = 50, nullable = false, unique = true
    )
    @Required
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_sala", nullable = false
    )
    @Required
    private Sala sala;

    public
    String getNombre() {
        return nombre;
    }

    public
    Sala getSala() {
        return sala;
    }

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
        return "Estante{" + "nombre='" + nombre + '\'' + ", sala=" + sala + '}';
    }
}
