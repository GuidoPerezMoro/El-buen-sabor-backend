package com.example.buensaborback.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
public class Categoria extends Base{

    private String denominacion;


    @ManyToMany(mappedBy = "categorias")
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACIÓN DE LA LISTA
    @Builder.Default
    private Set<Sucursal> sucursales = new HashSet<>();

    @OneToMany
    //SE AGREGA EL JOIN COLUMN PARA QUE JPA NO CREE LA TABLA INTERMEDIA EN UNA RELACIÓN ONE TO MANY
    //DE ESTA MANERA PONE EL FOREIGN KEY 'categoria_id' EN LA TABLA DE LOS MANY
    @JoinColumn(name = "categoria_id")
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACIÓN DE LA LISTA
    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    @OneToMany
    //SE AGREGA EL JOIN COLUMN PARA QUE JPA NO CREE LA TABLA INTERMEDIA EN UNA RELACION ONE TO MANY
    //DE ESTA MANERA PONE EL FOREIGN KEY 'categoria_id' EN LA TABLA DE LOS MANY
    @JoinColumn(name = "categoria_id")
    //SE AGREGA EL BUILDER.DEFAULT PARA QUE BUILDER NO SOBREESCRIBA LA INICIALIZACION DE LA LISTA
    @Builder.Default
    private Set<Categoria> subCategorias = new HashSet<>();

}
