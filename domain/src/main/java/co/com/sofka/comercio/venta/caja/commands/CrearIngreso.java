package co.com.sofka.comercio.venta.caja.commands;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.IngresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Command;

public class CrearIngreso extends Command {

    private final IngresoId ingresoId;
    private final Valor valor;
    private final CajaId cajaId;

    public CrearIngreso(IngresoId ingresoId, Valor valor, CajaId cajaId) {
        this.ingresoId = ingresoId;
        this.valor = valor;
        this.cajaId = cajaId;
    }

    public IngresoId getIngresoId() {
        return ingresoId;
    }

    public Valor getValor() {
        return valor;
    }

    public CajaId getCajaId() {
        return cajaId;
    }
}
