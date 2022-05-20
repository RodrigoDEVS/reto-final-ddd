package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.commands.ActualizarValorIngreso;

public class ActualizarValorIngresoUseCase extends UseCase<RequestCommand<ActualizarValorIngreso>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarValorIngreso> actualizarValorIngresoRequestCommand) {
        var command = actualizarValorIngresoRequestCommand.getCommand();
        var caja = Caja.from(command.getCajaId(), repository().getEventsBy(command.getCajaId().value()));
        caja.actualizarValorIngreso(command.getIngresoId(), command.getValor());

        emit().onResponse(new ResponseEvents((caja.getUncommittedChanges())));
    }
}
