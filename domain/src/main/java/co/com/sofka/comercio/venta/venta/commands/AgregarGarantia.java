package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.GarantiaId;
import co.com.sofka.domain.generic.Command;

public class AgregarGarantia extends Command {

    private final GarantiaId garantiaId;
    private final Fecha fecha;

    public AgregarGarantia(GarantiaId garantiaId, Fecha fecha) {
        this.garantiaId = garantiaId;
        this.fecha = fecha;
    }

    public GarantiaId getGarantiaId() {
        return garantiaId;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
