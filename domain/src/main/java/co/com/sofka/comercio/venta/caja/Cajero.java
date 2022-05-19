package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.values.CajeroId;
import co.com.sofka.domain.generic.Entity;

public class Cajero extends Entity<CajeroId> {

    public Cajero(CajeroId cajeroId) {
        super(cajeroId);
    }
}
