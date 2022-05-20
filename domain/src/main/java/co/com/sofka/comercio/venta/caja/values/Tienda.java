package co.com.sofka.comercio.venta.caja.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tienda implements ValueObject<String> {

    private final String value;

    public Tienda(String value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
