package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.Cajero;
import co.com.sofka.comercio.venta.caja.Egreso;
import co.com.sofka.comercio.venta.caja.Ingreso;
import co.com.sofka.domain.generic.DomainEvent;

public class CajaCreada extends DomainEvent {

    private final Cajero cajero;
    private final Ingreso ingreso;
    private final Egreso egreso;

    public CajaCreada(Cajero cajero, Ingreso ingreso, Egreso egreso) {
        super("co.com.sofka.comercio.venta.caja.events.CajaCreada");
        this.cajero = cajero;
        this.ingreso = ingreso;
        this.egreso = egreso;
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
