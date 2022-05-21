package co.com.sofka.comercio.venta.venta.services;

import co.com.sofka.comercio.venta.caja.values.Cierre;
import co.com.sofka.comercio.venta.venta.values.VentaId;

public interface ConsultarCierreVenta {

    Cierre consultarPorVentaId(VentaId ventaId);
}
