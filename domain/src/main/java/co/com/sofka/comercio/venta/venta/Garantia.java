package co.com.sofka.comercio.venta.venta;

import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.GarantiaId;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Garantia extends Entity<GarantiaId> {

    protected Fecha fecha;

    public Garantia(GarantiaId garantiaId, Fecha fecha) {
        super(garantiaId);
        this.fecha = fecha;
    }

    public void modificarFecha(Fecha fecha){
        this.fecha = Objects.requireNonNull(fecha);
    }
}
