package co.com.sofka.comercio.venta.caja.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Telefono implements ValueObject<Long> {

    private final Long value;

    public Telefono(Long value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Long value() {
        return value;
    }
}
