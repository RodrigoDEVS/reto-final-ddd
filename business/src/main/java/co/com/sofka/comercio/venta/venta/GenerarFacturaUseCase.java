package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.Caja;
import co.com.sofka.comercio.venta.venta.commands.GenerarFactura;

public class GenerarFacturaUseCase extends UseCase<RequestCommand<GenerarFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarFactura> generarFacturaRequestCommand) {
        var command = generarFacturaRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));
        venta.generarFactura(command.getFecha(), command.getValor());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
