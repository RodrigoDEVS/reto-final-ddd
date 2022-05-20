package co.com.sofka.comercio.venta.caja.commands;

import co.com.sofka.comercio.venta.caja.Cajero;
import co.com.sofka.comercio.venta.caja.Egreso;
import co.com.sofka.comercio.venta.caja.Ingreso;
import co.com.sofka.comercio.venta.caja.values.CajaId;
import co.com.sofka.comercio.venta.caja.values.Tienda;
import co.com.sofka.domain.generic.Command;

public class CrearCaja extends Command {

    private final CajaId cajaId;
    private final Tienda tienda;

    public CrearCaja(CajaId cajaId, Tienda tienda) {
        this.cajaId = cajaId;
        this.tienda = tienda;
    }

    public CajaId getCajaId() {
        return cajaId;
    }

    public Tienda getTienda() {
        return tienda;
    }
}
