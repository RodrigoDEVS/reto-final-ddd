package co.com.sofka.comercio.venta.carrito.events;

import co.com.sofka.comercio.venta.carrito.values.ConsolaId;
import co.com.sofka.comercio.venta.carrito.values.Modelo;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.carrito.values.Tipo;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ConsolaAgregada extends DomainEvent {
    private final ConsolaId consolaId;
    private final Sistema sistema;
    private final Tipo tipo;
    private final Modelo modelo;
    private final Valor valor;

    public ConsolaAgregada(ConsolaId consolaId, Sistema sistema, Tipo tipo, Modelo modelo, Valor valor) {
        super("co.com.sofka.comercio.venta.carrito.events.ConsolaAgregada");
        this.consolaId = consolaId;
        this.sistema = sistema;
        this.tipo = tipo;
        this.modelo = modelo;
        this.valor = valor;
    }

    public ConsolaId getConsolaId() {
        return consolaId;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Valor getValor() {
        return valor;
    }
}
