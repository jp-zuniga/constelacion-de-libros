package org.ConstelacionDeLibros.models.usuarios;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.models.operaciones.Reserva;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Stereotype;
import org.openxava.annotations.Tab;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@Tab(properties = "cedula, nombres, apellidos, email, telefono, direccion")
public
class Cliente extends BaseUsuario implements Auditable {
    @Embedded
    private Auditoria auditoria;

    @Column(length = 255)
    @Stereotype("ADDRESS")
    private String direccion;

    @OneToMany(mappedBy = "cliente")
    @ListProperties("fechaReserva, libro.titulo, estado")
    private Collection<Reserva> reservas;

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
        return "Cliente{" + "direccion='" + direccion + '\'' + ", reservas="
               + reservas + '}';
    }
}