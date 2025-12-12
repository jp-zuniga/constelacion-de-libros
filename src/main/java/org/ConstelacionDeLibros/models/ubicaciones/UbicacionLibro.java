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
class UbicacionLibro extends BaseEntity implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_columna", nullable = false
    )
    @Required
    private EstanteColumna columna;

    @Column(
        length = 200, nullable = true
    )
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
        String ruta = "";

        if (columna != null) {
            String sala = columna.getFila().getEstante().getSala().getNombre();
            ruta = sala + ": " + columna.toString();
        }

        return ruta + (
            observacion != null && ! observacion.isEmpty() ? " (" + observacion
                                                             + ")" : ""
        );
    }
}
