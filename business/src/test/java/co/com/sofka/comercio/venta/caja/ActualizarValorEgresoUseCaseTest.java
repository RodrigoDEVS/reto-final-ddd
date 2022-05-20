package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.commands.ActualizarTelefonoCajero;
import co.com.sofka.comercio.venta.caja.commands.ActualizarValorEgreso;
import co.com.sofka.comercio.venta.caja.events.*;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
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
public class ActualizarValorEgresoUseCaseTest {

    @InjectMocks
    private ActualizarValorEgresoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarValorEgresoHappyPass(){
        //arrange
        CajaId cajaId = CajaId.of("dddd");
        EgresoId egresoId = new EgresoId("aaaa");
        Valor valor = new Valor(10000D);
        var command = new ActualizarValorEgreso(egresoId, valor, cajaId);

        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(cajaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(ValorEgresoActualizado)events.get(0);
        Assertions.assertEquals(10000D,event.getValor().value());
        Mockito.verify(repository).getEventsBy(cajaId.value());
    }
    private List<DomainEvent> history(){
        Tienda tienda = new Tienda("Mundo Mario");
        var event = new CajaCreada(tienda);
        event.setAggregateRootId("xxxx");
        var eventEgreso = new EgresoCreado(EgresoId.of("aaaa"), new Valor(5000D));
        return List.of(event,eventEgreso);
    }
}
