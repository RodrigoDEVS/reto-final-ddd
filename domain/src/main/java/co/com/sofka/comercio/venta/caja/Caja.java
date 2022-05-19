package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.domain.generic.AggregateEvent;

public class Caja extends AggregateEvent<CajaId> {
    protected Cajero cajero;
    protected Ingreso ingreso;
    protected Egreso egreso;

    public Caja(CajaId cajaId, Cajero cajero, Ingreso ingreso, Egreso egreso) {
        super(cajaId);
        appendChange(new CajaCreada(cajero, ingreso, egreso)).apply();
        subscribe(new CajaEventChange(this));
    }
}
