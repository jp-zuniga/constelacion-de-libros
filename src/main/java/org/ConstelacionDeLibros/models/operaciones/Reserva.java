package org.ConstelacionDeLibros.models.operaciones;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.libros.Ejemplar;
import org.ConstelacionDeLibros.models.libros.Libro;
import org.ConstelacionDeLibros.models.usuarios.Cliente;
import org.ConstelacionDeLibros.models.usuarios.Empleado;
import org.openxava.annotations.DefaultValueCalculator;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Required;
import org.openxava.calculators.CurrentDateCalculator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public
class Reserva extends BaseEntity {
    @Column(nullable = false)
    @Required
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private LocalDate fechaReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @Required
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombres, apellidos")
    private Empleado atendidoPor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro", nullable = false)
    @Required
    @DescriptionsList(descriptionProperties = "titulo")
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ejemplar")
    private Ejemplar ejemplar;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    @Required
    private EstadoReserva estado;

    @Override
    public
    String toString() {
        return "Reserva{" + "fechaReserva=" + fechaReserva + ", cliente="
               + cliente + ", atendidoPor=" + atendidoPor + ", libro=" + libro
               + ", ejemplar=" + ejemplar + ", estado=" + estado + '}';
    }
}