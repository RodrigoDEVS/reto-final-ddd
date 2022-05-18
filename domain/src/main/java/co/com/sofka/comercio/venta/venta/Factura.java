package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.values.FacturaId;
import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Factura extends Entity<FacturaId> {
    protected Fecha fecha;
    protected Valor valor;

    public Factura(FacturaId facturaId, Fecha fecha, Valor valor) {
        super(facturaId);
        this.fecha = fecha;
        this.valor = valor;
    }

    public void actualizarValor(Valor valor){
        this.valor = Objects.requireNonNull(valor);
    }
}
