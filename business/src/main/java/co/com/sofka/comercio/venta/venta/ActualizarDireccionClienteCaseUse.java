package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.venta.commands.ActualizarDireccionCliente;

public class ActualizarDireccionClienteCaseUse extends UseCase<RequestCommand<ActualizarDireccionCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDireccionCliente> actualizarDireccionClienteRequestCommand) {
        var command = actualizarDireccionClienteRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));
        venta.actualizarDireccionCliente(command.getClienteId(), command.getDireccion());

        emit().onResponse(new ResponseEvents((venta.getUncommittedChanges())));
    }
}
