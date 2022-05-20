package co.com.sofka.comercio.venta.carrito.commands;

import co.com.sofka.comercio.venta.carrito.values.CarritoId;
import co.com.sofka.comercio.venta.carrito.values.Formato;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.carrito.values.VideojuegoId;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Command;

public class AplicarOfertaVideojuego extends Command {

    private final VideojuegoId videojuegoId;
    private final Nombre nombre;
    private final Sistema sistema;
    private final Formato formato;
    private final Valor valor;
    private final CarritoId carritoId;

    public AplicarOfertaVideojuego(VideojuegoId videojuegoId, Nombre nombre, Sistema sistema, Formato formato, Valor valor, CarritoId carritoId) {
        this.videojuegoId = videojuegoId;
        this.nombre = nombre;
        this.sistema = sistema;
        this.formato = formato;
        this.valor = valor;
        this.carritoId = carritoId;
    }

    public VideojuegoId getVideojuegoId() {
        return videojuegoId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Formato getFormato() {
        return formato;
    }

    public Valor getValor() {
        return valor;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }
}
