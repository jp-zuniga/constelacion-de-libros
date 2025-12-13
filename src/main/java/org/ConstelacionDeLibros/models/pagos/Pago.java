package org.ConstelacionDeLibros.models.pagos;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.usuarios.Cliente;
import org.ConstelacionDeLibros.models.usuarios.Empleado;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;
import org.openxava.calculators.CurrentDateCalculator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
@Tab(properties = "fechaPago, cliente.nombres, cliente.apellidos, montoTotal, metodoPago")
public class Pago extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Empleado registradoPor;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    @Required
    private MetodoPago metodoPago;

    @Column(nullable = false)
    @Required
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private LocalDate fechaPago;

    @Column(nullable = false, scale = 2)
    @Required
    private BigDecimal montoTotal;

    @Column(length = 60)
    private String referencia;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListProperties("concepto, monto")
    private Collection<PagoDetalle> detalles;

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
        return "Pago{" + "cliente=" + cliente + ", registradoPor=" + registradoPor +
               ", metodoPago=" + metodoPago + ", fechaPago=" + fechaPago +
               ", montoTotal=" + montoTotal + '}';
    }
}
