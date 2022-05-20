package co.com.sofka.comercio.venta.carrito.commands;

import co.com.sofka.comercio.venta.carrito.values.CarritoId;
import co.com.sofka.comercio.venta.carrito.values.ControlId;
import co.com.sofka.comercio.venta.carrito.values.Disenio;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Command;

public class AplicarOfertaControl extends Command {

    private final ControlId controlId;
    private final Sistema sistema;
    private final Disenio disenio;
    private final Valor valor;
    private final CarritoId carritoId;

    public AplicarOfertaControl(ControlId controlId, Sistema sistema, Disenio disenio, Valor valor, CarritoId carritoId) {
        this.controlId = controlId;
        this.sistema = sistema;
        this.disenio = disenio;
        this.valor = valor;
        this.carritoId = carritoId;
    }

    public ControlId getControlId() {
        return controlId;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Disenio getDisenio() {
        return disenio;
    }

    public Valor getValor() {
        return valor;
    }

    public CarritoId getCarritoId() {
        return carritoId;
    }
}
