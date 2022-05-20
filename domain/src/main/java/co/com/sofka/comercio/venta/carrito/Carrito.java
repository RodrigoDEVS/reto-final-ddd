package co.com.sofka.comercio.venta.carrito;

import co.com.sofka.comercio.venta.carrito.events.*;
import co.com.sofka.comercio.venta.carrito.values.*;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
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

    public Carrito(CarritoId carritoId) {
        super(carritoId);
        subscribe(new CarritoEventChange(this));
    }

    public static Carrito from(CarritoId carritoId, List<DomainEvent> events){
        var carrito = new Carrito(carritoId);
        events.forEach(carrito::applyEvent);
        return carrito;
    }

    public void agregarConsola(Sistema sistema, Tipo tipo, Modelo modelo, Valor valor){
        var consolaId = new ConsolaId();
        appendChange(new ConsolaAgregada(consolaId, sistema, tipo, modelo, valor)).apply();
    }

    public void agregarVideojuego(Nombre nombre, Sistema sistema, Formato formato, Valor valor){
        var videojuegoId = new VideojuegoId();
        appendChange(new VideojuegoAgregado(videojuegoId, nombre, sistema, formato, valor)).apply();
    }
    public void agregarControl(Sistema sistema, Disenio disenio, Valor valor){
        var controlId = new ControlId();
        appendChange(new ControlAgregado(controlId, sistema, disenio, valor)).apply();
    }

    public void aplicarOfertaConsola(ConsolaId consolaId, Valor valor){
        appendChange(new OfertaAplicadaConsola(consolaId, valor)).apply();
    }

    public void aplicarOfertaControl(ControlId controlId, Valor valor){
        appendChange(new OfertaAplicadaControl(controlId, valor)).apply();
    }

    public void aplicarOfertaVideojuego(VideojuegoId videojuegoId, Valor valor){
        appendChange(new OfertaAplicadaVideojuego(videojuegoId, valor)).apply();
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
