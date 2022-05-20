package co.com.sofka.comercio.venta.carrito;

import co.com.sofka.comercio.venta.carrito.values.Formato;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.carrito.values.VideojuegoId;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Entity;

public class Videojuego extends Entity<VideojuegoId> {

    protected Nombre nombre;
    protected Sistema sistema;
    protected Formato formato;
    protected Valor valor;

    public Videojuego(VideojuegoId videojuegoId, Nombre nombre, Sistema sistema, Formato formato, Valor valor) {
        super(videojuegoId);
        this.nombre = nombre;
        this.sistema = sistema;
        this.formato = formato;
        this.valor = valor;
    }

    public void aplicarOferta(Valor valor){
        this.valor = (valor);
    }
}
