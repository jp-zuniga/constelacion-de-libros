package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public
class Autor extends BaseEntity {
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
    String toString() {
        return nombres + " " + apellidos;
    }
}