package co.com.sofka.comercio.venta.caja.values;

import co.com.sofka.domain.generic.ValueObject;

public class Telefono implements ValueObject<Integer> {

    private final Integer value;

    public Telefono(Integer value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
