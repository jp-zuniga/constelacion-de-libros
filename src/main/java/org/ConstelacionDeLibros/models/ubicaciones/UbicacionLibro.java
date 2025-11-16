package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UbicacionLibro extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_columna", nullable = false)
    @Required
    private EstanteColumna columna;

    @Column(length = 200, nullable = true)
    private String observacion;

    @Override
    public String toString() {
        return "UbicacionLibro{" + "columna=" + columna + ", observacion='" +
               observacion + '\'' + '}';
    }
}
