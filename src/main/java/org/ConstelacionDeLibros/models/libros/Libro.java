package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Libro extends BaseEntity {
    @Column(
        length = 120,
        nullable = false
    )
    @Required
    private String titulo;

    @Column(nullable = false)
    @ManyToMany(
        fetch = FetchType.LAZY,
        mappedBy = "autor"
    )
    private Set<Autor> autores;

    @Column(
        length = 20,
        nullable = false,
        unique = true
    )
    @Required
    private String isbn;

    @Column(nullable = false)
    @Required
    private Date fechaPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_categoria",
        nullable = false
    )
    @Required
    private Editorial editorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "id_categoria",
        nullable = false
    )
    @Required
    private Categoria categoria;

    @Override
    public String toString() {
        return "Libro{" + "titulo='" + titulo + '\'' + ", autores=" + autores
               + ", isbn='" + isbn + '\'' + ", fechaPublicacion="
               + fechaPublicacion + ", editorial=" + editorial + ", categoria="
               + categoria + '}';
    }
}
