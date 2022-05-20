package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.commands.CrearCaja;
import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.Tienda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearCajaUseCaseTest {

    private CrearCajaUseCase useCase;

    @BeforeEach
    public void setup(){useCase = new CrearCajaUseCase();}

    @Test
    public void crearCajaHappyPass(){
        //arrange
        CajaId cajaId = CajaId.of("xxxx");
        Tienda tienda = new Tienda("Mundo Mario");
        var command = new CrearCaja(cajaId, tienda);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var cajaCreada = (CajaCreada)events.get(0);
        Assertions.assertEquals("xxxx", cajaCreada.aggregateRootId());
        Assertions.assertEquals("Mundo Mario", cajaCreada.getTienda().value());

    }
}
