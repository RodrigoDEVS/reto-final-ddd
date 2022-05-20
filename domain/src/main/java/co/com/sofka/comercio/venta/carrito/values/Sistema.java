package co.com.sofka.comercio.venta.carrito.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Sistema implements ValueObject<String> {

    private final String value;

    public Sistema(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
