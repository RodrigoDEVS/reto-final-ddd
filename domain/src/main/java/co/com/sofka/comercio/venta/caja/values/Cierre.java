package co.com.sofka.comercio.venta.caja.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Cierre implements ValueObject<Double> {

    private final Double value;

    public Cierre(Double value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Double value() {
        return value;
    }
}
