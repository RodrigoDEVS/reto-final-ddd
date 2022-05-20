package co.com.sofka.comercio.venta.carrito;

import co.com.sofka.comercio.venta.carrito.events.*;
import co.com.sofka.comercio.venta.carrito.values.VideojuegoId;
import co.com.sofka.comercio.venta.venta.events.DireccionClienteActualizada;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.EventChange;

public class CarritoEventChange extends EventChange {
    public CarritoEventChange(Carrito carrito) {
        apply((CarritoCreado event) -> {
            carrito.valor = event.getValor();
        });

        apply((ConsolaAgregada event) -> {
            var consolaId = event.getConsolaId();
            var consola = new Consola(consolaId, event.getSistema(), event.getTipo(), event.getModelo(), event.getValor());
            carrito.consolas.put(consolaId, consola);
        });

        apply((ControlAgregado event) -> {
            var controlId = event.getControlId();
            var control = new Control(controlId, event.getSistema(), event.getDisenio(), event.getValor());
            carrito.controles.put(controlId, control);
        });

        apply((VideojuegoAgregado event) -> {
            var videojuegoId = event.getVideojuegoId();
            var videojuego = new Videojuego(videojuegoId, event.getNombre(), event.getSistema(), event.getFormato(), event.getValor());
            carrito.videojuegos.put(videojuegoId, videojuego);
        });

        apply((OfertaAplicadaConsola event) -> {
            var consolaId = event.getConsolaId();
            var valor = event.getValor();
            var descuento = valor.value()*0.1D;
            var valorConDescuento = new Valor(valor.value()+descuento);
            carrito.aplicarOfertaConsola(consolaId, valorConDescuento);
        });

        apply((OfertaAplicadaControl event) -> {
            var controlId = event.getControlId();
            var valor = event.getValor();
            var descuento = valor.value()*0.1D;
            var valorConDescuento = new Valor(valor.value()+descuento);
            carrito.aplicarOfertaControl(controlId, valorConDescuento);
        });

        apply((OfertaAplicadaVideojuego event) -> {
            var videojuegoId = event.getVideojuegoId();
            var valor = event.getValor();
            var descuento = valor.value()*0.1D;
            var valorConDescuento = new Valor(valor.value()+descuento);
            carrito.aplicarOfertaVideojuego(videojuegoId, valorConDescuento);
        });
    }
}
