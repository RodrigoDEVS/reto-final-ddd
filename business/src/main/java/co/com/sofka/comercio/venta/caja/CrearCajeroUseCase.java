package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.commands.CrearCajero;

public class CrearCajeroUseCase extends UseCase<RequestCommand<CrearCajero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCajero> crearCajeroRequestCommand) {
        var command = crearCajeroRequestCommand.getCommand();
        var caja = Caja.from(command.getCajaId(), repository().getEventsBy(command.getCajaId().value()));
        caja.crearCajero(command.getNombre(), command.getCedula(), command.getTelefono());

        emit().onResponse(new ResponseEvents(caja.getUncommittedChanges()));
    }
}
