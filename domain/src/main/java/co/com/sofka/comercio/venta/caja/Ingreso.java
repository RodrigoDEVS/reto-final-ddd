package co.com.sofka.comercio.venta.caja;

import co.com.sofka.comercio.venta.caja.values.IngresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Entity;

public class Ingreso extends Entity<IngresoId> {

    protected Valor valor;

    public Ingreso(IngresoId ingresoId, Valor valor) {
        super(ingresoId);
        this.valor = valor;
    }

    public void actualizarValor(Valor valor){
        this.valor = valor;
    }
}
