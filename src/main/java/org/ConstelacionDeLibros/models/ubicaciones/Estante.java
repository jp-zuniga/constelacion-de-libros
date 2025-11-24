package org.ConstelacionDeLibros.models.ubicaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public
class Estante extends BaseEntity {

    @Column(
        length = 50, nullable = false, unique = true
    )
    @Required
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_sala", nullable = false
    )
    @Required
    private Sala sala;

    @Override
    public
    String toString() {
        return "Estante{" + "nombre='" + nombre + '\'' + ", sala=" + sala + '}';
    }
}
