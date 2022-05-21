package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.comercio.venta.venta.events.VentaFinalizada;

public class ActualizarCierreUseCase extends UseCase<TriggeredEvent<VentaFinalizada>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<VentaFinalizada> ventaFinalizadaTriggeredEvent) {
        var event = ventaFinalizadaTriggeredEvent.getDomainEvent();
        var caja = Caja.from(event.getCajaId(), repository().getEventsBy(event.getCajaId().value()));

        caja.actualizarCierre(event.getCierre());

        emit().onResponse(new ResponseEvents(caja.getUncommittedChanges()));
    }
}
