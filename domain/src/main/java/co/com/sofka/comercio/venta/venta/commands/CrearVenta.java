package co.com.sofka.comercio.venta.venta.commands;

import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.comercio.venta.venta.values.VentaId;
import co.com.sofka.domain.generic.Command;

public class CrearVenta extends Command {
    private final VentaId ventaId;

    private final CajaId cajaId;
    private final Valor valor;

    public CrearVenta(VentaId ventaId, CajaId cajaId, Valor valor) {
        this.ventaId = ventaId;
        this.cajaId = cajaId;
        this.valor = valor;
    }

    public VentaId getVentaId() {
        return ventaId;
    }

    public Valor getValor() {
        return valor;
    }

    public CajaId getCajaId() {
        return cajaId;
    }
}
