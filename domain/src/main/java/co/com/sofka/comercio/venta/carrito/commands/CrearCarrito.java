package co.com.sofka.comercio.venta.carrito.commands;

import co.com.sofka.comercio.venta.carrito.values.CarritoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Command;

public class CrearCarrito extends Command {

    private final CarritoId carritoId;
    private final Valor valor;

    public CrearCarrito(CarritoId carritoId, Valor valor) {
        this.carritoId = carritoId;
        this.valor = valor;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }

    public Valor getValor() {
        return valor;
    }
}
