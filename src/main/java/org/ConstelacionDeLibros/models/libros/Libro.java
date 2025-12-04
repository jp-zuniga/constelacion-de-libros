package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.ListProperties;
import org.openxava.annotations.Required;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public
class Libro extends BaseEntity {
    @Column(length = 120, nullable = false)
    @Required
    private String titulo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "libro_autor",
        joinColumns = @JoinColumn(name = "libro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )

    @ListProperties("nombres, apellidos")
    private Set<Autor> autores = new HashSet<>();

    @Column(length = 20, nullable = false, unique = true)
    @Required
    private String isbn;

    @Column(nullable = false)
    @Required
    private Integer anioPublicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_editorial", nullable = false)
    @Required
    private Editorial editorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    @Required
    private Categoria categoria;

    @Override
    public
    String toString() {
        return "Libro{" + "titulo='" + titulo + '\'' + ", autores=" + autores
               + ", isbn='" + isbn + '\'' + ", anioPublicacion="
               + anioPublicacion + ", editorial=" + editorial + ", categoria="
               + categoria + '}';
    }
}