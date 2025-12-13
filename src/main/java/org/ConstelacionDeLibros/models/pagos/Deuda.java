package org.ConstelacionDeLibros.models.pagos;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.usuarios.Cliente;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class Deuda extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @Required
    private Cliente cliente;

    @Column(nullable = false, scale = 2)
    @Required
    private BigDecimal montoAdeudado;

    @Column(nullable = false)
    @Required
    private LocalDate fechaEmision;

    @Column(nullable = false)
    private boolean cancelada = false;

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
        return "Deuda{" + "auditoria=" + auditoria + ", cliente=" + cliente
               + ", montoAdeudado=" + montoAdeudado + ", fechaEmision="
               + fechaEmision + ", cancelada=" + cancelada + '}';
    }
}