package Entities;
import java.util.HashSet;
import java.util.Set;

public class Categoria {
    private String denominacion;
    private Set<Categoria> subcategorias;

    public Categoria() {
    }

    public Categoria(String denominacion) {
        this.denominacion = denominacion;
        this.subcategorias = new HashSet<>();
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Set<Categoria> getSubcategorias() {
        return subcategorias;
    }

    public void setSubcategorias(Set<Categoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    public void agregarSubcategoria(Categoria subcategoria){
        this.subcategorias.add(subcategoria);
    }

    public void quitarSubcategoria(Categoria subcategoria){
        if (this.subcategorias.remove(subcategoria)) {
            System.out.println("Subcategoria " + subcategoria.getDenominacion() + " eliminada");
        } else {
            System.out.println("La subcategoria no existe en la categoria padre");
        }
    }
}
