package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.commands.ActualizarValorEgreso;

public class ActualizarValorEgresoUseCase extends UseCase<RequestCommand<ActualizarValorEgreso>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<ActualizarValorEgreso> actualizarValorEgresoRequestCommand) {
        var command = actualizarValorEgresoRequestCommand.getCommand();
        var caja = Caja.from(command.getCajaId(), repository().getEventsBy(command.getCajaId().value()));
        caja.actualizarValorEgreso(command.getEgresoId(), command.getValor());

        emit().onResponse(new ResponseEvents((caja.getUncommittedChanges())));
    }
}
