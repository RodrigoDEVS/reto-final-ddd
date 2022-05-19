package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.AggregateEvent;

public class Caja extends AggregateEvent<CajaId> {
    protected Cajero cajero;
    protected Ingreso ingreso;
    protected Egreso egreso;

    public Caja(CajaId cajaId, Cajero cajero, Ingreso ingreso, Egreso egreso) {
        super(cajaId);
        appendChange(new CajaCreada(cajero, ingreso, egreso)).apply();
        subscribe(new CajaEventChange(this));
    }

    public void actualizarValorIngreso(IngresoId ingresoId, Valor valor){
        appendChange(new ValorIngresoActualizado(ingresoId, valor)).apply();
    }

    public void actualizarValorEgreso(EgresoId egresoId, Valor valor){
        appendChange(new ValorEgresoActualizado(egresoId, valor)).apply();
    }

    public void actualizarTelefonoCajero(CajeroId cajeroId, Telefono telefono){
        appendChange(new TelefonoCajeroActualizado(telefono)).apply();
    }
}
