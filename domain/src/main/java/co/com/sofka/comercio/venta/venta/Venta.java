package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.events.DireccionClienteActualizada;
import co.com.sofka.comercio.venta.venta.events.FacturaGenerada;
import co.com.sofka.comercio.venta.venta.events.FechaGarantiaActualizada;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.venta.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Venta extends AggregateEvent<VentaId> {
    protected Factura factura;
    protected Cliente cliente;
    protected Garantia garantia;
    protected Valor valor;

    public Venta(VentaId ventaId, Factura factura, Cliente cliente, Garantia garantia, Valor valor) {
        super(ventaId);
        appendChange(new VentaCreada(factura, cliente, garantia, valor)).apply();
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

    public void actualizarDireccionCliente(ClienteId clienteId, Direccion direccion){
        appendChange(new DireccionClienteActualizada(clienteId, direccion)).apply();
    }

    public void modificarFechaGarantia(GarantiaId garantiaId, Fecha fecha){
        appendChange(new FechaGarantiaActualizada(garantiaId, fecha)).apply();
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
