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
public class Empresa extends Base{
    private String nombre;
    private String razonSocial;
    private int cuil;
    private Set<Sucursal> sucursales = new HashSet<>();

    public Empresa(String nombre, String razonSocial, int cuil) {
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.cuil = cuil;
        this.sucursales = new HashSet<>();
    }

    public void agregarSucursal(Sucursal sucursal){
        this.sucursales.add(sucursal);
        System.out.println("Sucursal " + sucursal.getNombre() + " agregada");
    }
}
