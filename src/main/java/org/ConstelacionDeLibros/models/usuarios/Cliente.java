package org.ConstelacionDeLibros.models.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.ConstelacionDeLibros.models.reservas.Reserva;
import org.openxava.annotations.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
public class Cliente extends BaseEntity {

    @Column(length = 20, nullable = false, unique = true)
    @Required
    private String cedula; //no estoy segura de esto pero lo puse asi pq asi esta en el documetno. corrijan si quieren

    @Column(length = 80, nullable = false)
    @Required
    private String nombres;

    @Column(length = 80, nullable = false)
    @Required
    private String apellidos;

    @Column(length = 15)
    @Stereotype("TELEPHONE")
    private String telefono;

    @Column(length = 100)
    @Stereotype("EMAIL")
    private String email;

    @Column(length = 255)
    @Stereotype("ADDRESS")
    private String direccion;


    @OneToMany(mappedBy = "cliente")
    @ListProperties("fechaReserva, libro.titulo, estado")
    private Collection<Reserva> reservas;

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
}