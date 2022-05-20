package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.venta.commands.GenerarFactura;
import co.com.sofka.comercio.venta.venta.events.FacturaGenerada;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.venta.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GenerarFacturaUseCaseTest {

    @InjectMocks
    private GenerarFacturaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void generarFacturaHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("xxxx");
        FacturaId facturaId = new FacturaId("10AA20BB");
        Fecha fecha = new Fecha(LocalDate.now(), LocalDateTime.now());
        Valor valor = new Valor(3500000D);
        var command = new GenerarFactura(facturaId, fecha, valor, ventaId);

        when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (FacturaGenerada)events.get(0);
        Assertions.assertEquals(fecha, event.getFecha());
        Assertions.assertEquals(3500000D, event.getValor().value());
    }
    private List<DomainEvent> history(){
        Valor valor = new Valor(0D);
        var event = new VentaCreada(valor);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
