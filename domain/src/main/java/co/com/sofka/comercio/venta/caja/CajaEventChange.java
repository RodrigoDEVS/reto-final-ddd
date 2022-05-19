package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.events.TelefonoCajeroActualizado;
import co.com.sofka.comercio.venta.caja.events.ValorEgresoActualizado;
import co.com.sofka.comercio.venta.caja.events.ValorIngresoActualizado;
import co.com.sofka.domain.generic.EventChange;

public class CajaEventChange extends EventChange {
    public CajaEventChange(Caja caja) {
        apply((CajaCreada event) ->{
            caja.cajero = event.getCajero();
            caja.ingreso = event.getIngreso();
            caja.egreso = event.getEgreso();
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
