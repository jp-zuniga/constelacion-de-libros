package org.ConstelacionDeLibros.models.pagos;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class PagoDetalle extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago", nullable = false)
    @Required
    private Pago pago;

    @Column(length = 150, nullable = false)
    @Required
    private String concepto;

    @Column(nullable = false, scale = 2)
    @Required
    private BigDecimal monto;

    @Column(length = 200)
    private String observacion;

    @OneToMany(
        mappedBy = "detalle", cascade = CascadeType.ALL, orphanRemoval = true
    )
    @ListProperties("destinoDescripcion, montoAplicado, fechaAplicacion")
    private Collection<PagoAplicacion> aplicaciones;

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
        return "PagoDetalle{" + "pago=" + pago + ", concepto='" + concepto
               + '\'' + ", monto=" + monto + ", observacion='" + observacion
               + '\'' + '}';
    }
}
