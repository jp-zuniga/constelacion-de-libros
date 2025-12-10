package org.ConstelacionDeLibros.config;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public
class Auditoria {
    private String usuarioIng;
    private String usuarioAct;
    private LocalDate fechaIng;
    private LocalDate fechaAct;

    public
    String getUsuarioIng() {
        return usuarioIng;
    }

    public
    void setUsuarioIng(String usuarioIng) {
        this.usuarioIng = usuarioIng;
    }

    public
    String getUsuarioAct() {
        return usuarioAct;
    }

    public
    void setUsuarioAct(String usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public
    LocalDate getFechaIng() {
        return fechaIng;
    }

    public
    void setFechaIng(LocalDate fechaIng) {
        this.fechaIng = fechaIng;
    }

    public
    LocalDate getFechaAct() {
        return fechaAct;
    }

    public
    void setFechaAct(LocalDate fechaAct) {
        this.fechaAct = fechaAct;
    }
}
