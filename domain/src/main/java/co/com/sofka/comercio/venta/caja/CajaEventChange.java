package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.events.*;
import co.com.sofka.comercio.venta.caja.values.EgresoId;
import co.com.sofka.domain.generic.EventChange;

public class CajaEventChange extends EventChange {
    public CajaEventChange(Caja caja) {
        apply((CajaCreada event) ->{
            caja.tienda = event.getTienda();
        });

        apply((CajeroCreado event) -> {
            var cajeroId = event.getCajeroId();
            var cajero = new Cajero(cajeroId, event.getNombre(), event.getCedula(), event.getTelefono());
            caja.cajero = cajero;
        });

        apply((IngresoCreado event) -> {
            var ingresoId = event.getIngresoId();
            var ingreso = new Ingreso(ingresoId, event.getValor());
            caja.ingreso = ingreso;
        });

        apply((EgresoCreado event) -> {
            var egresoId = event.getEgresoId();
            var egreso = new Egreso(egresoId, event.getValor());
            caja.egreso = egreso;
        });

        apply((ValorIngresoActualizado event) -> {
            caja.ingreso.actualizarValor(event.getValor());
        });

        apply((ValorEgresoActualizado event) -> {
            caja.egreso.actualizarValor(event.getValor());
        });

        apply((TelefonoCajeroActualizado event) -> {
            caja.cajero.actualizarTelefono(event.getTelefono());
        });
    }
}
