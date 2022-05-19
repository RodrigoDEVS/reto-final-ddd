package co.com.sofka.comercio.venta.caja.values;

import co.com.sofka.domain.generic.Identity;

public class IngresoId extends Identity {

    public IngresoId(String id) {
        super(id);
    }

    public IngresoId() {
    }

    public static IngresoId of(String id){
        return new IngresoId(id);
    }
}
