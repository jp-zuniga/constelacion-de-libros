package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.Required;
import org.openxava.annotations.ListProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Libro extends BaseEntity {

    @Column(length = 120, nullable = false)
    @Required
    private String titulo;

    /*deje la relacion en los dos pq si solo la dejaba aqui, cuando abria un libro podia ver
    * todos los autores del libro pero si abro autor no me enseñaba los libros del autor, entonces
    * lo deje asi pero corrijanme si me equivoco*/
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
    public String toString() {
        return titulo;
    }
}