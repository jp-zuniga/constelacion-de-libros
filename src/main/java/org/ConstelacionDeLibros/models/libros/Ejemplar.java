package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.ubicaciones.UbicacionLibro;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class Ejemplar extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_libro", nullable = false
    )
    @Required
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_ubicacion", nullable = false
    )
    @Required
    private UbicacionLibro ubicacion;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    @Required
    private EstadoEjemplar estado;

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
        return "Ejemplar{" + "libro=" + libro + ", ubicacion=" + ubicacion
               + ", estado=" + estado + '}';
    }
}
