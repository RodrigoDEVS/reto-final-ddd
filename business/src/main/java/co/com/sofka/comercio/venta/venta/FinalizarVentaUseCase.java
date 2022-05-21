package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.venta.commands.FinalizarVenta;
import co.com.sofka.comercio.venta.venta.services.ConsultarCierreVenta;

public class FinalizarVentaUseCase extends UseCase<RequestCommand<FinalizarVenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<FinalizarVenta> finalizarVentaRequestCommand) {
        var command = finalizarVentaRequestCommand.getCommand();
        var cierreService = getService(ConsultarCierreVenta.class).orElseThrow();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));

        venta.finalizarVenta(cierreService.consultarPorVentaId(command.getVentaId()));

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
