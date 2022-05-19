package co.com.sofka.comercio.venta.caja.commands;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.EgresoId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Command;

public class ActualizarValorEgreso extends Command {

    private final EgresoId egresoId;
    private final Valor valor;
    private final CajaId cajaId;

    public ActualizarValorEgreso(EgresoId egresoId, Valor valor, CajaId cajaId) {
        this.egresoId = egresoId;
        this.valor = valor;
        this.cajaId = cajaId;
    }

    public EgresoId getEgresoId() {
        return egresoId;
    }

    public Valor getValor() {
        return valor;
    }

    public CajaId getCajaId() {
        return cajaId;
    }
}
