package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class FinalizarVenta extends Command {

    private final VentaId ventaId;

    public FinalizarVenta(VentaId ventaId) {
        this.ventaId = ventaId;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
