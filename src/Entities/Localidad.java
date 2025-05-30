package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Localidad extends Base{
    private String nombre;
    private Provincia provincia;

    public Localidad(String nombre) {
        this.nombre = nombre;
    }
}
