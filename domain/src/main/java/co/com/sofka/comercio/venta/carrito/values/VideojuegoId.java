package co.com.sofka.comercio.venta.carrito.values;

import co.com.sofka.domain.generic.Identity;

public class VideojuegoId extends Identity {

    public VideojuegoId(String id) {
        super(id);
    }

    public VideojuegoId() {
    }

    public static VideojuegoId of(String id){
        return new VideojuegoId(id);
    }
}
