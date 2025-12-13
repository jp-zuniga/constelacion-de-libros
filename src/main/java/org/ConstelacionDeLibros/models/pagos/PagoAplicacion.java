package org.ConstelacionDeLibros.models.pagos;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.calculators.CurrentDateCalculator;

import lombok.Getter;
import lombok.Setter;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public class PagoAplicacion extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_detalle", nullable = false)
    @Required
    private PagoDetalle detalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_deuda")
    @DescriptionsList(descriptionProperties = "cliente.nombres, cliente.apellidos, fechaEmision")
    private Deuda deuda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_multa")
    @DescriptionsList(descriptionProperties = "nombre, prestamo.cliente.nombres, prestamo.cliente.apellidos")
    private Multa multa;

    @Column(nullable = false, scale = 2)
    @Required
    private BigDecimal montoAplicado;

    @Column(nullable = false)
    @Required
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private LocalDate fechaAplicacion;

    @Column(length = 200)
    private String comentario;

    @Transient
    public String getDestinoDescripcion() {
        // Allows the UI to show where the payment was applied without exposing internals.
        if (deuda != null) {
            return "Deuda #" + deuda.getId();
        }
        if (multa != null) {
            return "Multa #" + multa.getId();
        }
        return "";
    }

    @Override
    public Auditoria getAuditoria() {
        return auditoria;
    }

    @Override
    public void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    @Override
    public String toString() {
        return "PagoAplicacion{" + "detalle=" + detalle + ", deuda=" + deuda +
               ", multa=" + multa + ", montoAplicado=" + montoAplicado +
               ", fechaAplicacion=" + fechaAplicacion + '}';
    }
}
