package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.events.*;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Caja extends AggregateEvent<CajaId> {
    protected Cajero cajero;
    protected Ingreso ingreso;
    protected Egreso egreso;

    protected Tienda tienda;

    protected Cierre cierre;

    public Caja(CajaId cajaId, Tienda tienda) {
        super(cajaId);
        appendChange(new CajaCreada(tienda)).apply();
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

    public void actualizarCierre(Cierre cierre){
        appendChange(new CierreActualizado(cierre)).apply();
    }

    public void crearCajero(Nombre nombre, Cedula cedula, Telefono telefono){
        var cajeroId = new CajeroId();
        appendChange(new CajeroCreado(cajeroId, nombre, cedula, telefono)).apply();
    }

    public void crearIngreso(Valor valor){
        var ingresoId = new IngresoId();
        appendChange(new IngresoCreado(ingresoId, valor)).apply();
    }

    public void crearEgreso(Valor valor){
        var egresoId = new EgresoId();
        appendChange(new EgresoCreado(egresoId, valor)).apply();
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
