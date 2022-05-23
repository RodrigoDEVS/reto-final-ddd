package co.com.sofka.comercio.venta.venta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Fecha implements ValueObject<Fecha.Pros> {

    private final LocalDate dia;
    private final LocalTime hora;

    public Fecha(LocalDate dia, LocalTime hora) {
        //TODO: Agregar validaciones (fechas futuras, el dia debe ser de 24H)
        this.dia = Objects.requireNonNull(dia);
        this.hora = Objects.requireNonNull(hora);
    }

    @Override
    public Pros value() {
        return new Pros() {
            @Override
            public LocalDate dia() {
                return dia;
            }

            @Override
            public LocalTime hora() {
                return hora;
            }
        };
    }

    public interface Pros{
        LocalDate dia();
        LocalTime hora();
    }
}
