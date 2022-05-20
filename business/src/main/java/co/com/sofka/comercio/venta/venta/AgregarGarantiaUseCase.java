package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.venta.commands.AgregarGarantia;

public class AgregarGarantiaUseCase extends UseCase<RequestCommand<AgregarGarantia>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarGarantia> agregarGarantiaRequestCommand) {
        var command = agregarGarantiaRequestCommand.getCommand();
        var venta = Venta.from(command.getVentaId(), repository().getEventsBy(command.getVentaId().value()));
        venta.agregarGarantia(command.getFecha());

        emit().onResponse(new ResponseEvents(venta.getUncommittedChanges()));
    }
}
