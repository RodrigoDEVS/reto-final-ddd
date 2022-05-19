package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.values.EgresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Entity;

import java.util.Objects;

public class Egreso extends Entity<EgresoId> {

    protected Valor valor;

    public Egreso(EgresoId egresoId, Valor valor) {
        super(egresoId);
        this.valor = valor;
    }

    public void actualizarValor(Valor valor){
        this.valor = Objects.requireNonNull(valor);
    }
}
