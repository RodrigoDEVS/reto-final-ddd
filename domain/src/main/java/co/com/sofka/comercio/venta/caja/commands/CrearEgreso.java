package co.com.sofka.comercio.venta.caja.commands;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.EgresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Command;

public class CrearEgreso extends Command {

    private final EgresoId egresoId;
    private final Valor valor;
    private final CajaId cajaId;

    public CrearEgreso(EgresoId egresoId, Valor valor, CajaId cajaId) {
        this.egresoId = egresoId;
        this.valor = valor;
        this.cajaId = cajaId;
    }


    public Valor getValor() {
        return valor;
    }

    public CajaId getCajaId() {
        return cajaId;
    }
}
