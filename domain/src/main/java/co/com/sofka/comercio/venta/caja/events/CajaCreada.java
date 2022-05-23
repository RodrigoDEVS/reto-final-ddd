package co.com.sofka.comercio.venta.caja.events;

import co.com.sofka.comercio.venta.caja.values.Tienda;
import co.com.sofka.domain.generic.DomainEvent;

public class CajaCreada extends DomainEvent {

    private final Tienda tienda;

    public CajaCreada(Tienda tienda) {
        super("co.com.sofka.comercio.venta.caja.events.CajaCreada");
        this.tienda = tienda;
    }

    public Tienda getTienda() {
        return tienda;
    }
}
