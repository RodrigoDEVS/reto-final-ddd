package co.com.sofka.comercio.venta.carrito.values;

import co.com.sofka.domain.generic.Identity;

public class ControlId extends Identity {

    public ControlId(String id) {
        super(id);
    }

    public ControlId() {
    }

    public static ControlId of(String id){
        return new ControlId(id);
    }
}
