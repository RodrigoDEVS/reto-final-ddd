package co.com.sofka.comercio.venta.carrito.values;

import co.com.sofka.domain.generic.ValueObject;

public class Tipo implements ValueObject<String> {

    private final String value;

    public Tipo(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
