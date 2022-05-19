package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.events.TelefonoCajeroActualizado;
import co.com.sofka.comercio.venta.caja.events.ValorEgresoActualizado;
import co.com.sofka.comercio.venta.caja.events.ValorIngresoActualizado;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Caja extends AggregateEvent<CajaId> {
    protected Cajero cajero;
    protected Ingreso ingreso;
    protected Egreso egreso;

    public Caja(CajaId cajaId, Cajero cajero, Ingreso ingreso, Egreso egreso) {
        super(cajaId);
        appendChange(new CajaCreada(cajero, ingreso, egreso)).apply();
        subscribe(new CajaEventChange(this));
    }

    public Caja(CajaId cajaId){
        super(cajaId);
        subscribe(new CajaEventChange(this));
    }

    public static Caja from(CajaId cajaId, List<DomainEvent> events){
        var caja = new Caja(cajaId);
        events.forEach(caja::applyEvent);
        return caja;
    }
    public void actualizarValorIngreso(IngresoId ingresoId, Valor valor){
        appendChange(new ValorIngresoActualizado(ingresoId, valor)).apply();
    }

    public void actualizarValorEgreso(EgresoId egresoId, Valor valor){
        appendChange(new ValorEgresoActualizado(egresoId, valor)).apply();
    }

    public void actualizarTelefonoCajero(CajeroId cajeroId, Telefono telefono){
        appendChange(new TelefonoCajeroActualizado(cajeroId, telefono)).apply();
    }

    public Cajero getCajero() {
        return cajero;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public Egreso getEgreso() {
        return egreso;
    }
}
