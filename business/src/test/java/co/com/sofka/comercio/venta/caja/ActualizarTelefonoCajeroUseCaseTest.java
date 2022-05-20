package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.commands.ActualizarTelefonoCajero;
import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.events.CajeroCreado;
import co.com.sofka.comercio.venta.caja.events.TelefonoCajeroActualizado;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ActualizarTelefonoCajeroUseCaseTest {

    @InjectMocks
    private ActualizarTelefonoCajeroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarTelefonoCajeroHappyPass(){
        //arrange
        CajaId cajaId = CajaId.of("dddd");
        CajeroId cajeroId = new CajeroId("aaaa");
        Telefono telefono = new Telefono(3152441);
        var command = new ActualizarTelefonoCajero(cajeroId, telefono, cajaId);

        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(cajaId.value())
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(TelefonoCajeroActualizado)events.get(0);
        Assertions.assertEquals(3152441,event.getTelefono().value());
        Mockito.verify(repository).getEventsBy(cajaId.value());
    }
    private List<DomainEvent> history(){
        Tienda tienda = new Tienda("Mundo Mario");
        var event = new CajaCreada(tienda);
        event.setAggregateRootId("xxxx");
        var eventCajero = new CajeroCreado(CajeroId.of("aaaa"), new Nombre("Rodrigo"), new Cedula(16986), new Telefono(3005475));
        return List.of(event,eventCajero);
    }
}
