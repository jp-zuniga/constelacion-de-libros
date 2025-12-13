package org.ConstelacionDeLibros.models.pagos;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Required;
import org.openxava.calculators.CurrentLocalDateCalculator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class PagoAplicacion extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle", nullable = false)
    @Required
    private PagoDetalle detalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deuda")
    private Deuda deuda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_multa")
    private Multa multa;

    @Column(nullable = false, scale = 2)
    @Required
    private BigDecimal montoAplicado;

    @Column(nullable = false)
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate fechaAplicacion;

    @Column(length = 200)
    private String comentario;

    @Transient
    public
    String getDestinoDescripcion() {
        if (deuda != null) {
            return "Deuda #" + deuda.getId();
        }

        if (multa != null) {
            return "Multa #" + multa.getId();
        }

        return "";
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
        return "PagoAplicacion{" + "detalle=" + detalle + ", deuda=" + deuda
               + ", multa=" + multa + ", montoAplicado=" + montoAplicado
               + ", fechaAplicacion=" + fechaAplicacion + '}';
    }
}
