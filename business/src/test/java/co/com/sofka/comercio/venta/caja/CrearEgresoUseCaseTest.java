package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.commands.CrearCajero;
import co.com.sofka.comercio.venta.caja.commands.CrearEgreso;
import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.events.CajeroCreado;
import co.com.sofka.comercio.venta.caja.events.EgresoCreado;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.values.Nombre;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearEgresoUseCaseTest {
    @InjectMocks
    private CrearEgresoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void crearEgresoHappyPass(){
        //arrange
        CajaId cajaId = CajaId.of("xxxx");
        EgresoId egresoId = new EgresoId("aaaa");
        Valor valor = new Valor(5000000D);
        var command = new CrearEgreso(egresoId, valor, cajaId);

        when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (EgresoCreado)events.get(0);
        Assertions.assertEquals(5000000D, event.getValor().value());
    }
    private List<DomainEvent> history(){
        Tienda tienda = new Tienda("Mundo Mario");
        var event = new CajaCreada(tienda);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
