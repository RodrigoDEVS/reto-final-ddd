package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.Cliente;
import co.com.sofka.comercio.venta.venta.Factura;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaCreada extends DomainEvent {
    private final Factura factura;

    private final Cliente cliente;
    private final Valor valor;
    public VentaCreada(Factura factura, Cliente cliente, Valor valor) {
        super("co.com.sofka.comercio.events.VentaCreada");
        this.factura = factura;
        this.cliente = cliente;
        this.valor = valor;
    }

    public Factura getFactura() {
        return factura;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Valor getValor() {
        return valor;
    }
}
