package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.values.FacturaId;
import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Entity;

public class Factura extends Entity<FacturaId> {
    protected Fecha fecha;
    protected Valor valor;

    public Factura(FacturaId entityId, Fecha fecha, Valor valor) {
        super(entityId);
        this.fecha = fecha;
        this.valor = valor;
    }
}
