package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.ubicaciones.UbicacionLibro;
import org.openxava.annotations.Required;

import javax.persistence.*;

@Entity
@Getter
@Setter
public
class Ejemplar extends BaseEntity {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_estado_ejemplar", nullable = false
    )
    @Required
    private EstadoEjemplar estado;

    @Column(
        length = 40, nullable = false, unique = true
    )
    @Required
    private String codigoBarra;

    @Override
    public
    String toString() {
        return "Ejemplar{" + "libro=" + libro + ", ubicacion=" + ubicacion
               + ", estado=" + estado + ", codigoBarra='" + codigoBarra + '\''
               + '}';
    }
}
