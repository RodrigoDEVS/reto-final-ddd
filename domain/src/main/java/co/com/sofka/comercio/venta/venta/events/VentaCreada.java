package co.com.sofka.comercio.venta.venta.events;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;

public class VentaCreada extends DomainEvent {
    private final Valor valor;
    private final CajaId cajaId;

    public VentaCreada(Valor valor, CajaId cajaId) {
        super("co.com.sofka.comercio.events.VentaCreada");
        this.valor = valor;
        this.cajaId = cajaId;
    }

    public Valor getValor() {
        return valor;
    }

    public CajaId getCajaId() {
        return cajaId;
    }
}
