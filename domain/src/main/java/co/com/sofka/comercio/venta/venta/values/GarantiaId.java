package co.com.sofka.comercio.venta.venta.values;

import co.com.sofka.domain.generic.Identity;

public class GarantiaId extends Identity {

    public GarantiaId(String id) {
        super(id);
    }

    public GarantiaId() {
    }

    public static GarantiaId of(String id){
        return new GarantiaId(id);
    }
}
