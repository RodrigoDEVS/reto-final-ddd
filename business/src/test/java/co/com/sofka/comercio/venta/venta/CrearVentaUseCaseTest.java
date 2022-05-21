package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.venta.commands.CrearVenta;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CrearVentaUseCaseTest {

    private CrearVentaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new CrearVentaUseCase();
    }

    @Test
    public void CrearVentaHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("01A01A01A");
        Valor valor = new Valor(0D);
        CajaId cajaId = CajaId.of("asdf");
        var command = new CrearVenta(ventaId, cajaId, valor);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var ventaCreada = (VentaCreada)events.get(0);
        Assertions.assertEquals("01A01A01A", ventaCreada.aggregateRootId());
        Assertions.assertEquals(0D, ventaCreada.getValor().value());
    }
}
