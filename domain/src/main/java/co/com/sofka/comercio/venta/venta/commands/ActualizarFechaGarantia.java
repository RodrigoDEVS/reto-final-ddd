package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.GarantiaId;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class ActualizarFechaGarantia extends Command {

    private final GarantiaId garantiaId;
    private final Fecha fecha;
    private final VentaId ventaId;

    public ActualizarFechaGarantia(GarantiaId garantiaId, Fecha fecha, VentaId ventaId) {
        this.garantiaId = garantiaId;
        this.fecha = fecha;
        this.ventaId = ventaId;
    }

    public GarantiaId getGarantiaId() {
        return garantiaId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public VentaId getVentaId() {
        return ventaId;
    }
}
