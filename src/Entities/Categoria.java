package Entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categoria {
    private String denominacion;
    private Categoria categoriaPadre;
    private Set<Categoria> subcategorias = new HashSet<>();
    private Set<Articulo> articulos = new HashSet();

    public void quitarSubcategoria(Categoria subcategoria){
        if (this.subcategorias.remove(subcategoria)) {
            System.out.println("Subcategoria " + subcategoria.getDenominacion() + " eliminada");
        } else {
            System.out.println("La subcategoria no existe en la categoria padre");
        }
    }

    public void agregarArticuli(Articulo articulo){
        this.articulos.add(articulo);
    }
}
