package co.com.sofka.comercio.venta.carrito;

import co.com.sofka.comercio.venta.carrito.events.CarritoCreado;
import co.com.sofka.domain.generic.EventChange;

public class CarritoEventChange extends EventChange {
    public CarritoEventChange(Carrito carrito) {
        apply((CarritoCreado event) -> {
            carrito.valor = event.getValor();
        });
    }
}
