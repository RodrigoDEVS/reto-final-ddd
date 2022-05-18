package co.com.sofka.comercio.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Valor implements ValueObject<Integer> {
    private final Integer value;

    public Valor(Integer value){
        this.value = Objects.requireNonNull(value);
        if(this.value==0){
            throw new IllegalArgumentException("El valor no puede ser cero");
        }
    }

    @Override
    public Integer value() {
        return value;
    }
}
