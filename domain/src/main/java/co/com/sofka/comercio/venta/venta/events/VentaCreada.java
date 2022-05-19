package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.Cliente;
import co.com.sofka.comercio.venta.venta.Factura;
import co.com.sofka.comercio.venta.venta.Garantia;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaCreada extends DomainEvent {
    private final Factura factura;
    private final Cliente cliente;
    private final Garantia garantia;
    private final Valor valor;
    public VentaCreada(Factura factura, Cliente cliente, Garantia garantia, Valor valor) {
        super("co.com.sofka.comercio.events.VentaCreada");
        this.factura = factura;
        this.cliente = cliente;
        this.garantia = garantia;
        this.valor = valor;
    }

    public Factura getFactura() {
        return factura;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public Garantia getGarantia(){
        return garantia;
    }

    public Valor getValor() {
        return valor;
    }
}
