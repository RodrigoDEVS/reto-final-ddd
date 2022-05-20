package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.commands.CrearCaja;
import co.com.sofka.comercio.venta.caja.commands.CrearCajero;
import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.events.CajeroCreado;
import co.com.sofka.comercio.venta.caja.events.IngresoCreado;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CrearCajeroUseCaseTest {
    @InjectMocks
    private CrearCajeroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearCajaHappyPass(){
        //arrange
        CajaId cajaId = CajaId.of("xxxx");
        CajeroId cajeroId = new CajeroId("aaaa");
        Nombre nombre = new Nombre("Rodrigo Gallego");
        Cedula cedula = new Cedula(16986186);
        Telefono telefono = new Telefono(3152441553L);
        var command = new CrearCajero(cajeroId, nombre, cedula, telefono, cajaId);

        when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (CajeroCreado)events.get(0);
        /*Assertions.assertEquals("xxxx", event.aggregateRootId());
        Assertions.assertEquals("aaaa", event.getCajeroId());*/
        Assertions.assertEquals("Rodrigo Gallego", event.getNombre().value());
        Assertions.assertEquals(16986186, event.getCedula().value());
        Assertions.assertEquals(3152441553L, event.getTelefono().value());
    }
    private List<DomainEvent> history(){
        Tienda tienda = new Tienda("Mundo Mario");
        var event = new CajaCreada(tienda);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
