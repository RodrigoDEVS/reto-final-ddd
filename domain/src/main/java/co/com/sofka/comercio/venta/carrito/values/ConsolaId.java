package co.com.sofka.comercio.venta.carrito.values;

import co.com.sofka.domain.generic.Identity;

public class ConsolaId extends Identity {

    public ConsolaId(String id) {
        super(id);
    }

    public ConsolaId() {
    }

    public static ConsolaId of(String id){
        return new ConsolaId(id);
    }
}
