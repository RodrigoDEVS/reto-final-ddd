package co.com.sofka.comercio.venta.carrito.values;

import co.com.sofka.domain.generic.Identity;

public class CarritoId extends Identity {

    public CarritoId(String id) {
        super(id);
    }

    public CarritoId() {
    }

    public static CarritoId of(String id){
        return new CarritoId(id);
    }
}
