package org.ConstelacionDeLibros.models.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.operaciones.Reserva;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Stereotype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
public
class Cliente extends BaseUsuario {
    @Column(length = 255)
    @Stereotype("ADDRESS")
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    @ListProperties("fechaReserva, libro.titulo, estado")
    private Collection<Reserva> reservas;

    @Override
    public
    String toString() {
        return "Cliente{" + "direccion='" + direccion + '\'' + ", reservas="
               + reservas + '}';
    }
}