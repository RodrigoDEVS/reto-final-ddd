package co.com.sofka.comercio.venta.carrito.commands;

import co.com.sofka.comercio.venta.carrito.values.*;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Command;

public class AplicarOfertaConsola extends Command {

    private final ConsolaId consolaId;
    private final Sistema sistema;
    private final Tipo tipo;
    private final Modelo modelo;
    private final Valor valor;
    private final CarritoId carritoId;

    public AplicarOfertaConsola(ConsolaId consolaId, Sistema sistema, Tipo tipo, Modelo modelo, Valor valor, CarritoId carritoId) {
        this.consolaId = consolaId;
        this.sistema = sistema;
        this.tipo = tipo;
        this.modelo = modelo;
        this.valor = valor;
        this.carritoId = carritoId;
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

    public CarritoId getCarritoId() {
        return carritoId;
    }
}
