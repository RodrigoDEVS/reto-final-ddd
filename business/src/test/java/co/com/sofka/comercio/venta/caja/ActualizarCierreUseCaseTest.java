package co.com.sofka.comercio.venta.caja;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.comercio.venta.caja.events.CajaCreada;
import co.com.sofka.comercio.venta.caja.events.CajeroCreado;
import co.com.sofka.comercio.venta.caja.events.CierreActualizado;
import co.com.sofka.comercio.venta.caja.values.*;
import co.com.sofka.comercio.venta.venta.events.VentaFinalizada;
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

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarCierreUseCaseTest {

    @InjectMocks
    private ActualizarCierreUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarCierreCajeroHappyPass(){
        //arrange
        CajaId cajaId = CajaId.of("dddd");
        Cierre cierre = new Cierre(5500000D);
        var event = new VentaFinalizada(cierre, cajaId);

        when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(cajaId.value())
                .syncExecutor(useCase,new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var cierreActualizado =(CierreActualizado)events.get(0);
        Assertions.assertEquals(5500000D, cierreActualizado.getCierre().value());
        Mockito.verify(repository).getEventsBy(cajaId.value());
    }
    private List<DomainEvent> history(){
        Tienda tienda = new Tienda("Mundo Mario");
        var event = new CajaCreada(tienda);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}