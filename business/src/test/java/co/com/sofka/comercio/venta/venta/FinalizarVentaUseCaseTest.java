package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.comercio.venta.venta.commands.FinalizarVenta;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.venta.events.VentaFinalizada;
import co.com.sofka.comercio.venta.venta.services.ConsultarCierreVenta;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FinalizarVentaUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Mock
    private ConsultarCierreVenta service;

    @InjectMocks
    private FinalizarVentaUseCase useCase;

    @Test
    void finalizarVenta(){
        var command = new FinalizarVenta(VentaId.of("dddd"));
        when(repository.getEventsBy("dddd")).thenReturn(history());
        when(service.consultarPorVentaId(any(VentaId.class))).thenReturn(new Cierre(3500000D));
        useCase.addRepository(repository);
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var event = (VentaFinalizada)events.get(0);
        Assertions.assertEquals(3500000D, event.getCierre().value());
    }

    private List<DomainEvent> history(){
        CajaId cajaId = new CajaId("dddd");
        Valor valor = new Valor(0D);
        var event = new VentaCreada(valor, cajaId);
        event.setAggregateRootId("dddd");
        return List.of(event);
    }
}