package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.values.IngresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorIngresoActualizado extends DomainEvent {
    public ValorIngresoActualizado(IngresoId ingresoId, Valor valor) {
        super();
    }
}
