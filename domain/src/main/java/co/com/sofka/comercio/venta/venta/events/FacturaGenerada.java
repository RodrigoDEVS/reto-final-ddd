package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.values.FacturaId;
import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class FacturaGenerada extends DomainEvent {
    private final FacturaId facturaId;
    private final Fecha fecha;
    private final Valor valor;

    public FacturaGenerada(FacturaId facturaId, Fecha fecha, Valor valor) {
        super("co.com.sofka.comercio.FacturaGenerada");
        this.facturaId = facturaId;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Fecha getFecha(){
        return fecha;
    }

    public Valor getValor(){
        return valor;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }
}
