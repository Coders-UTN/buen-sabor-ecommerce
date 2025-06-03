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

    public void agregarSubcategoria(Categoria categoria){
        this.subcategorias.add(categoria);
        categoria.setCategoriaPadre(this);
    }

    public void quitarSubcategoria(Categoria subcategoria){
        if (this.subcategorias.remove(subcategoria)) {
            subcategoria.setCategoriaPadre(null);
            System.out.println("Subcategoria " + subcategoria.getDenominacion() + " eliminada");
        } else {
            System.out.println("La subcategoria no existe en la categoria padre");
        }
    }

    public void agregarArticulo(Articulo articulo){
        this.articulos.add(articulo);
    }

    public void quitarArticulo(Articulo articulo) {
        if (this.articulos.remove(articulo)) {
            System.out.println("Articulo " + articulo.getDenominacion() + " eliminado");
        } else {
            System.out.println("No se encontro el articulo");
        }

    }
}
