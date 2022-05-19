package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.venta.values.FacturaId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class ValorFacturaActualizado extends DomainEvent {

    private final FacturaId facturaId;
    private final Valor valor;
    public ValorFacturaActualizado(FacturaId facturaId, Valor valor) {
        super("co.com.sofka.comercio.venta.events.ValorFacturaActualizado");
        this.facturaId = facturaId;
        this.valor = valor;
    }

    public FacturaId getFacturaId() {
        return facturaId;
    }

    public Valor getValor() {
        return valor;
    }
}
