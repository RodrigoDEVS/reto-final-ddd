package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.venta.commands.ActualizarValorFactura;

public class ActualizarValorFacturaUseCase extends UseCase<RequestCommand<ActualizarValorFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarValorFactura> actualizarValorFacturaRequestCommand) {
        var command = actualizarValorFacturaRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));
        venta.actualizarValorFactura(command.getFacturaId(), command.getValor());

        emit().onResponse(new ResponseEvents((venta.getUncommittedChanges())));
    }
}
