package co.com.sofka.comercio.venta.carrito.events;

import co.com.sofka.comercio.venta.carrito.values.VideojuegoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class OfertaAplicadaVideojuego extends DomainEvent {
    private final VideojuegoId videojuegoId;
    private final Valor valor;

    public OfertaAplicadaVideojuego(VideojuegoId videojuegoId, Valor valor) {
        super("co.com.sofka.comercio.venta.carrito.events.ConsolaAgregada");
        this.videojuegoId = videojuegoId;
        this.valor = valor;
    }

    public VideojuegoId getVideojuegoId() {
        return videojuegoId;
    }

    public Valor getValor() {
        return valor;
    }
}
