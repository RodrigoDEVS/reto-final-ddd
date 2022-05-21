package co.com.sofka.comercio.venta.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoDeVenta implements ValueObject<EstadoDeVenta.Estados> {

    private final Estados value;

    public EstadoDeVenta(Estados value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Estados value() {
        return value;
    }

    public enum Estados{
        POR_INICIAR, EN_PROCESO, FINALIZADA
    }
}
