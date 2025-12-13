package org.ConstelacionDeLibros.models.operaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.libros.Ejemplar;
import org.ConstelacionDeLibros.models.libros.Libro;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.Required;
import org.openxava.calculators.CurrentLocalDateCalculator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class Inventario extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro", nullable = false)
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ejemplar", nullable = false)
    private Ejemplar ejemplar;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    @Required
    private TipoMovimiento tipoMov;

    @Column(nullable = false)
    @Required
    private Integer cantidad;

    @Column(nullable = false)
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    private LocalDate fecha;

    @Column(length = 200, nullable = false)
    private String observacion;

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
        return "Inventario{libro=" + libro + ", ejemplar=" + ejemplar
               + ", tipoMov=" + tipoMov + ", cantidad=" + cantidad + ", fecha="
               + fecha + ", observacion='" + observacion + '\'' + '}';
    }
}
