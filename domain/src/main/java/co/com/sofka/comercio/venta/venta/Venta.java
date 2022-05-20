package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.events.*;
import co.com.sofka.comercio.venta.venta.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Venta extends AggregateEvent<VentaId> {
    protected Factura factura;
    protected Cliente cliente;
    protected Garantia garantia;

    protected Valor valor;

    public Venta(VentaId ventaId, Valor valor) {
        super(ventaId);
        appendChange(new VentaCreada(valor)).apply();
        subscribe(new VentaEventChange(this));
    }

    private Venta(VentaId ventaId){
        super(ventaId);
        subscribe(new VentaEventChange(this));
    }

    public static Venta from(VentaId ventaId, List<DomainEvent> events){
        var venta = new Venta(ventaId);
        events.forEach(venta::applyEvent);
        return venta;
    }

    public void generarFactura(Fecha fecha, Valor valor){
        var facturaId = new FacturaId();
        appendChange(new FacturaGenerada(facturaId, fecha, valor)).apply();
    }

    public void agregarCliente(Nombre nombre, Direccion direccion){
        var clienteId = new ClienteId();
        appendChange(new ClienteAgregado(clienteId, nombre, direccion)).apply();
    }

    public void agregarGarantia(Fecha fecha){
        var garantiaId = new GarantiaId();
        appendChange(new GarantiaAgregada(garantiaId, fecha)).apply();
    }

    public void actualizarValorFactura(FacturaId facturaId, Valor valor){
        appendChange(new ValorFacturaActualizado(facturaId, valor)).apply();
    }
    public void actualizarDireccionCliente(ClienteId clienteId, Direccion direccion){
        appendChange(new DireccionClienteActualizada(clienteId, direccion)).apply();
    }

    public Factura factura() {
        return factura;
    }

    public Cliente cliente(){
        return cliente;
    }

    public Garantia garantia(){
        return garantia;
    }

    public Valor valor() {
        return valor;
    }
}
