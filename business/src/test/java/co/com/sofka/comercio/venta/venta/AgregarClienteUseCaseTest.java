package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.venta.commands.AgregarCliente;
import co.com.sofka.comercio.venta.venta.events.ClienteAgregado;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.venta.values.*;
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
public class AgregarClienteUseCaseTest {

    @InjectMocks
    private AgregarClienteUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void agregarClienteHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("xxxx");
        ClienteId clienteId = new ClienteId("10AA20BB");
        Nombre nombre = new Nombre("Rodrigo");
        Direccion direccion = new Direccion("Calle 34 con 21");
        var command = new AgregarCliente(clienteId, nombre, direccion, ventaId);

        when(repository.getEventsBy("xxxx")).thenReturn(history());
        useCase.addRepository(repository);
        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //asserts
        var event = (ClienteAgregado)events.get(0);
        Assertions.assertEquals("Rodrigo", event.getNombre().value());
        Assertions.assertEquals("Calle 34 con 21", event.getDireccion().value());
    }
    private List<DomainEvent> history(){
        Valor valor = new Valor(0D);
        var event = new VentaCreada(valor);
        event.setAggregateRootId("xxxx");
        return List.of(event);
    }
}
