package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.comercio.venta.venta.events.*;
import co.com.sofka.comercio.venta.venta.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Venta extends AggregateEvent<VentaId> {

    protected CajaId cajaId;
    protected Factura factura;
    protected Cliente cliente;
    protected Garantia garantia;

    protected Valor valor;

    protected Cierre cierre;

    protected EstadoDeVenta estadoDeVenta;

    public Venta(VentaId ventaId, CajaId cajaId, Valor valor) {
        super(ventaId);
        appendChange(new VentaCreada(valor, cajaId)).apply();
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

    public void modificarFechaGarantia(GarantiaId garantiaId, Fecha fecha){
        appendChange(new FechaGarantiaModificada(garantiaId, fecha)).apply();
    }
    public void finalizarVenta(Cierre cierre){
        appendChange(new VentaFinalizada(cierre, cajaId)).apply();
    }

    public Valor valor() {
        return valor;
    }
}
