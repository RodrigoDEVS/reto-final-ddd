package co.com.sofka.comercio.venta.caja.values;

import co.com.sofka.domain.generic.Identity;

public class CajeroId extends Identity {

    public CajeroId(String id) {
        super(id);
    }

    public CajeroId() {
    }

    public static CajeroId of(String id){
        return new CajeroId(id);
    }
}
