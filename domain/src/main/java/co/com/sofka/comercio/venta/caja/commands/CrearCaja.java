package co.com.sofka.comercio.venta.caja.commands;

import co.com.sofka.comercio.venta.caja.Cajero;
import co.com.sofka.comercio.venta.caja.Egreso;
import co.com.sofka.comercio.venta.caja.Ingreso;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.domain.generic.Command;

public class CrearCaja extends Command {

    private final CajaId cajaId;
    private final Cajero cajero;
    private final Ingreso ingreso;
    private final Egreso egreso;

    public CrearCaja(CajaId cajaId, Cajero cajero, Ingreso ingreso, Egreso egreso) {
        this.cajaId = cajaId;
        this.cajero = cajero;
        this.ingreso = ingreso;
        this.egreso = egreso;
    }

    public CajaId getCajaId() {
        return cajaId;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public Egreso getEgreso() {
        return egreso;
    }
}
