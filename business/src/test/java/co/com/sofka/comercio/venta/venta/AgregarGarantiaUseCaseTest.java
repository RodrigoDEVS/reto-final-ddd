package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.venta.commands.AgregarGarantia;
import co.com.sofka.comercio.venta.venta.events.GarantiaAgregada;
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
public class AgregarGarantiaUseCaseTest {
    @InjectMocks
    private AgregarGarantiaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarGarantiaHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("xxxx");
        GarantiaId garantiaId = new GarantiaId("10AA20BB");
        Fecha fecha = new Fecha(LocalDate.now(), LocalDateTime.now());
        var command = new AgregarGarantia(garantiaId, fecha, ventaId);

        when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (GarantiaAgregada)events.get(0);
        Assertions.assertEquals(fecha, event.getFecha());
    }
    private List<DomainEvent> history(){
        CajaId cajaId = new CajaId("xxxx");
        Valor valor = new Valor(0D);
        var event = new VentaCreada(valor, cajaId);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
