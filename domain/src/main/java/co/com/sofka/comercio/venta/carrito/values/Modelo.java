package co.com.sofka.comercio.venta.carrito.values;

import co.com.sofka.domain.generic.ValueObject;

public class Modelo implements ValueObject<String> {

    private final String value;

    public Modelo(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
