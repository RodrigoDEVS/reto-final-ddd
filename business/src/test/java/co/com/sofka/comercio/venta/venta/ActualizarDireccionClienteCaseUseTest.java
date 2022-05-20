package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.venta.commands.ActualizarDireccionCliente;
import co.com.sofka.comercio.venta.venta.commands.ActualizarValorFactura;
import co.com.sofka.comercio.venta.venta.events.*;
import co.com.sofka.comercio.venta.venta.values.*;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ActualizarDireccionClienteCaseUseTest {

    @InjectMocks
    private ActualizarDireccionClienteCaseUse useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarDireccionClienteHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("dddd"); //se usa el .of para pasar el valor manual ya que es autoincrementable
        ClienteId clienteId = new ClienteId("CC16986186");
        Direccion direccion = new Direccion("Calle 34 No.21");
        var command = new ActualizarDireccionCliente(clienteId, direccion, ventaId);

        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(DireccionClienteActualizada)events.get(0);
        Assertions.assertEquals("Calle 34 No.21",event.getDireccion().value());
        Mockito.verify(repository).getEventsBy(ventaId.value());
    }
    private List<DomainEvent> history(){
        Valor valor = new Valor(0D);
        var event = new VentaCreada(valor);
        event.setAggregateRootId("dddd");
        var eventCliente = new ClienteAgregado(ClienteId.of("CC16986186"), new Nombre("Rodrigo Gallego"), new Direccion("Cra 15 con 16"));
        return List.of(event, eventCliente);
    }
}
