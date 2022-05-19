package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.venta.Factura;
import co.com.sofka.comercio.venta.venta.Garantia;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class CrearVenta extends Command {
    private final VentaId ventaId;
    private final Factura factura;
    private final Garantia garantia;
    private final Valor valor;

    public CrearVenta(VentaId ventaId, Factura factura, Garantia garantia, Valor valor) {
        this.ventaId = ventaId;
        this.factura = factura;
        this.garantia = garantia;
        this.valor = valor;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public Factura getFactura() {
        return factura;
    }

    public Garantia getGarantia(){
        return garantia;
    }
    public Valor getValor() {
        return valor;
    }
}
