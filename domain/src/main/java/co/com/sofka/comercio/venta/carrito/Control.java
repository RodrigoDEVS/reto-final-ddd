package co.com.sofka.comercio.venta.carrito;

import co.com.sofka.comercio.venta.carrito.values.ControlId;
import co.com.sofka.comercio.venta.carrito.values.Disenio;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Entity;

public class Control extends Entity<ControlId> {

    protected Sistema sistema;
    protected Disenio disenio;
    protected Valor valor;

    public Control(ControlId entityId, Sistema sistema, Disenio disenio, Valor valor) {
        super(entityId);
        this.sistema = sistema;
        this.disenio = disenio;
        this.valor = valor;
    }

    public void aplicarOferta(Valor valor){
        this.valor = (valor);
    }
}
