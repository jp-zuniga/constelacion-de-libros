package org.ConstelacionDeLibros.models.pagos;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.operaciones.Prestamo;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class Multa extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo", nullable = false)
    @Required
    private Prestamo prestamo;

    @Column(length = 80, nullable = false)
    @Required
    private String nombre;

    @Column(length = 200)
    private String descripcion;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    @Required
    private EstadoMulta estado;

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
        return nombre + " (" + estado + ")";
    }
}