package org.ConstelacionDeLibros.models.libros;

import lombok.Getter;
import lombok.Setter;
import org.ConstelacionDeLibros.config.Auditable;
import org.ConstelacionDeLibros.config.Auditoria;
import org.ConstelacionDeLibros.config.AuditoriaListener;
import org.ConstelacionDeLibros.models.BaseEntity;
import org.openxava.annotations.DescriptionsList;
import org.openxava.annotations.Hidden;
import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditoriaListener.class)
@Getter
@Setter
@Tab(
    properties = "titulo, isbn, editorial.nombre, categoria.nombre, "
                 + "anioPublicacion, autoresNombres"
)
public
class Libro extends BaseEntity implements Auditable {
    @Embedded
    @Hidden
    private Auditoria auditoria;

    @Column(length = 120, nullable = false)
    @Required
    private String titulo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "libro_autor",
        joinColumns = @JoinColumn(name = "libro_id"),
        inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    // @DescriptionsList(
    //     descriptionProperties = "nombres, apellidos", showReferenceView =
    //     true
    // )
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
    @DescriptionsList(descriptionProperties = "nombre")
    private Editorial editorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    @Required
    @DescriptionsList(descriptionProperties = "nombre")
    private Categoria categoria;

    public
    Auditoria getAuditoria() {
        return auditoria;
    }

    public
    void setAuditoria(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    @Override
    public
    String toString() {
        return "Libro{" + "titulo='" + titulo + '\'' + ", autores=" + autores
               + ", isbn='" + isbn + '\'' + ", anioPublicacion="
               + anioPublicacion + ", editorial=" + editorial + ", categoria="
               + categoria + '}';
    }
}