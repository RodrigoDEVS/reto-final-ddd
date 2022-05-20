package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.commands.ActualizarTelefonoCajero;

public class ActualizarTelefonoCajeroUseCase extends UseCase<RequestCommand<ActualizarTelefonoCajero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoCajero> actualizarTelefonoCajeroRequestCommand) {
        var command = actualizarTelefonoCajeroRequestCommand.getCommand();
        var caja = Caja.from(command.getCajaId(), repository().getEventsBy(command.getCajaId().value()));
        caja.actualizarTelefonoCajero(command.getCajeroId(), command.getTelefono());

        emit().onResponse(new ResponseEvents((caja.getUncommittedChanges())));
    }
}
