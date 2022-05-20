package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.commands.CrearEgreso;

public class CrearEgresoUseCase extends UseCase<RequestCommand<CrearEgreso>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearEgreso> crearEgresoRequestCommand) {
        var command = crearEgresoRequestCommand.getCommand();
        var caja = Caja.from(command.getCajaId(), repository().getEventsBy(command.getCajaId().value()));
        caja.crearEgreso(command.getValor());

        emit().onResponse(new ResponseEvents(caja.getUncommittedChanges()));
    }
}
