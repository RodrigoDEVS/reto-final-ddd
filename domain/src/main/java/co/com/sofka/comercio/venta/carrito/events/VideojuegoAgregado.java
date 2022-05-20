package co.com.sofka.comercio.venta.carrito.events;

import co.com.sofka.comercio.venta.carrito.values.Formato;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.carrito.values.VideojuegoId;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class VideojuegoAgregado extends DomainEvent {
    private final VideojuegoId videojuegoId;
    private final Nombre nombre;
    private final Sistema sistema;
    private final Formato formato;
    private final Valor valor;

    public VideojuegoAgregado(VideojuegoId videojuegoId, Nombre nombre, Sistema sistema, Formato formato, Valor valor) {
        super("co.com.sofka.comercio.venta.carrito.events.ConsolaAgregada");
        this.videojuegoId = videojuegoId;
        this.nombre = nombre;
        this.sistema = sistema;
        this.formato = formato;
        this.valor = valor;
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
}
