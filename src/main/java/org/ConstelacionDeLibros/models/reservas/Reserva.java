package org.ConstelacionDeLibros.models.reservas;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.libros.Ejemplar;
import org.ConstelacionDeLibros.models.libros.Libro;
import org.ConstelacionDeLibros.models.usuarios.Cliente;

import org.openxava.annotations.*;
import org.openxava.calculators.CurrentDateCalculator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Reserva extends BaseEntity {

    @Column(nullable = false)
    @Required
    @DefaultValueCalculator(CurrentDateCalculator.class) // Pone la fecha de hoy por defecto
    private LocalDate fechaReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    @Required
    @ReferenceView("Simple") // Opcional: Para ver una vista resumida si la defines
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro", nullable = false)
    @Required
    @DescriptionsList(descriptionProperties = "titulo") // Muestra el título en el desplegable
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ejemplar")
    // No es @Required porque a veces reservas solo el libro y el ejemplar se asigna después
    private Ejemplar ejemplar;

    @Column(length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    @Required
    private EstadoReserva estado;

    @Override
    public String toString() {
        // Muestra algo como: "Reserva de Don Quijote (2025-12-01)"
        return "Reserva de " + (libro != null ? libro.getTitulo() : "Libro") + " (" + fechaReserva + ")";
    }
}