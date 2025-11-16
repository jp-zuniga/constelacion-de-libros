package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class EstanteFila extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estante", nullable = false)
    @Required
    private Estante estante;

    @Column(nullable = false)
    @Required
    private Integer numero;

    @Override
    public String toString() {
        return "EstanteFila{" + "estante=" + estante + ", numero=" + numero +
               '}';
    }
}
