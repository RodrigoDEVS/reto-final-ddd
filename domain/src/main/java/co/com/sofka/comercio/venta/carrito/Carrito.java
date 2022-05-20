package co.com.sofka.comercio.venta.carrito;

import co.com.sofka.comercio.venta.carrito.values.*;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.AggregateEvent;

import java.util.Map;

public class Carrito extends AggregateEvent<CarritoId> {

    protected Map<ConsolaId, Consola> consolas;
    protected Map<VideojuegoId, Videojuego> videojuegos;
    protected Map<ControlId, Control> controles;
    protected Valor valor;

    public Carrito(CarritoId carritoId, Valor valor) {
        super(carritoId);
        appendChange(new CarritoCreado(valor)).apply();
        subscribe(new CarritoEventChange(this));
    }

    public void agregarControl(Sistema sistema, Disenio disenio, Valor valor){
        var controlId = new ControlId();
        appendChange(new ControlCreado(controlId, sistema, disenio, valor)).apply();
    }

    public Map<ConsolaId, Consola> Consolas() {
        return consolas;
    }

    public Map<VideojuegoId, Videojuego> Videojuegos() {
        return videojuegos;
    }

    public Map<ControlId, Control> Controles() {
        return controles;
    }

    public Valor Valor() {
        return valor;
    }
}
