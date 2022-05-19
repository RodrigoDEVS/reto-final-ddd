package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.domain.generic.EventChange;

public class CajaEventChange extends EventChange {
    public CajaEventChange(Caja caja) {
        apply((CajaCreada event) ->{
            caja.cajero = event.getCajero();
            caja.ingreso = event.getIngreso();
            caja.egreso = event.getEgreso();
        });
    }
}
