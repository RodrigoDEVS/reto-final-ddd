package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.commands.CrearIngreso;

public class CrearIngresoUseCase extends UseCase<RequestCommand<CrearIngreso>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearIngreso> crearIngresoRequestCommand) {
        var command = crearIngresoRequestCommand.getCommand();
        var caja = Caja.from(command.getCajaId(), repository().getEventsBy(command.getCajaId().value()));
        caja.crearIngreso(command.getValor());

        emit().onResponse(new ResponseEvents(caja.getUncommittedChanges()));
    }
}
