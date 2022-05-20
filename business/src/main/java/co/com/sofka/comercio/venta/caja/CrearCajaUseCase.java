package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.comercio.venta.caja.commands.CrearCaja;

public class CrearCajaUseCase extends UseCase<RequestCommand<CrearCaja>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCaja> crearCajaRequestCommand) {
        var command = crearCajaRequestCommand.getCommand();

        var caja = new Caja(command.getCajaId(), command.getTienda());

        emit().onResponse(new ResponseEvents(caja.getUncommittedChanges()));
    }
}
