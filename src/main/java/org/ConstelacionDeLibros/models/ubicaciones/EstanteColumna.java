package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EstanteColumna extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_fila",
        nullable = false
    )
    @Required
    private EstanteFila fila;

    @Column(nullable = false)
    @Required
    private Integer numero;

    @Override
    public String toString() {
        return "EstanteColumna{" + "fila=" + fila + ", numero=" + numero + '}';
    }
}
