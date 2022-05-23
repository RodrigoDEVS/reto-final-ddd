package co.com.sofka.comercio.venta.venta;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.venta.commands.ActualizarValorFactura;
import co.com.sofka.comercio.venta.venta.events.FacturaGenerada;
import co.com.sofka.comercio.venta.venta.events.ValorFacturaActualizado;
import co.com.sofka.comercio.venta.venta.events.VentaCreada;
import co.com.sofka.comercio.venta.venta.values.FacturaId;
import co.com.sofka.comercio.venta.venta.values.Fecha;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.comercio.venta.venta.values.VentaId;
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
import java.time.LocalTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ActualizarValorFacturaUseCaseTest {

    @InjectMocks
    private ActualizarValorFacturaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    public void actualizarValorFacturaHappyPass(){
        //arrange
        VentaId ventaId = VentaId.of("dddd"); //se usa el .of para pasar el valor manual ya que es autoincrementable
        FacturaId facturaId = new FacturaId("01AB58CD");
        Valor valor = new Valor(50500D);
        var command = new ActualizarValorFactura(facturaId, valor, ventaId);

        Mockito.when(repository.getEventsBy("dddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ventaId.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event =(ValorFacturaActualizado)events.get(0);
        Assertions.assertEquals(50500D,event.getValor().value());
        Mockito.verify(repository).getEventsBy(ventaId.value());
    }
    private List<DomainEvent> history(){
        CajaId cajaId = new CajaId("ccc");
        Valor valor = new Valor(0D);
        var event = new VentaCreada(valor, cajaId);
        event.setAggregateRootId("dddd");
        var eventFactura = new FacturaGenerada(FacturaId.of("01AB58CD"), new Fecha(LocalDate.now(), LocalTime.now()), new Valor(5000D));
        return List.of(event, eventFactura);
    }
}
