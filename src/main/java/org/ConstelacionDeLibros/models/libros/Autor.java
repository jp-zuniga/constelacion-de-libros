package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
public
class Autor extends BaseEntity implements Auditable {
    @Embedded
    @Hidden
    private Auditoria auditoria;

    @Column(length = 80, nullable = false)
    @Required
    private String nombres;

    @Column(length = 80, nullable = false)
    @Required
    private String apellidos;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "autores")
    @ListProperties("titulo, isbn, anioPublicacion, editorial.nombre")
    private Set<Libro> libros = new HashSet<>();

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
        return nombres + " " + apellidos;
    }
}