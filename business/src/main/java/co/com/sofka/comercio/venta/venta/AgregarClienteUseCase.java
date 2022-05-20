package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.venta.commands.AgregarCliente;

public class AgregarClienteUseCase extends UseCase<RequestCommand<AgregarCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCliente> agregarClienteRequestCommand) {
        var command = agregarClienteRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));
        venta.agregarCliente(command.getNombre(), command.getDireccion());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
