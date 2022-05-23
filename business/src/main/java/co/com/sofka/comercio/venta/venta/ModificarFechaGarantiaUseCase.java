package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.venta.commands.ModificarFechaGarantia;

public class ModificarFechaGarantiaUseCase extends UseCase<RequestCommand<ModificarFechaGarantia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ModificarFechaGarantia> modificarFechaGarantiaRequestCommand) {
        var command = modificarFechaGarantiaRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));
        venta.modificarFechaGarantia(command.getGarantiaId(), command.getFecha());

        emit().onResponse(new ResponseEvents((venta.getUncommittedChanges())));
    }
}
