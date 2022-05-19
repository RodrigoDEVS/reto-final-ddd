package co.com.sofka.comercio.venta.caja.values;

import co.com.sofka.domain.generic.Identity;

public class EgresoId extends Identity {

    public EgresoId(String id) {
        super(id);
    }

    public EgresoId() {
    }

    public static EgresoId of(String id){
        return new EgresoId(id);
    }
}
