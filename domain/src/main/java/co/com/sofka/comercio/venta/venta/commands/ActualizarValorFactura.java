package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.venta.values.FacturaId;
import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorFactura extends Command {

    private final FacturaId facturaId;
    private final Valor valor;
    private final VentaId ventaId;

    public ActualizarValorFactura(FacturaId facturaId, Valor valor, VentaId ventaId) {
        this.facturaId = facturaId;
        this.valor = valor;
        this.ventaId = ventaId;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Valor getValor() {
        return valor;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
