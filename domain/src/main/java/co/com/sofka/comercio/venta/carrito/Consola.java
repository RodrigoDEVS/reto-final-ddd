package co.com.sofka.comercio.venta.carrito;

import co.com.sofka.comercio.venta.carrito.values.ConsolaId;
import co.com.sofka.comercio.venta.carrito.values.Modelo;
import co.com.sofka.comercio.venta.carrito.values.Sistema;
import co.com.sofka.comercio.venta.carrito.values.Tipo;
import co.com.sofka.comercio.venta.venta.values.Valor;
import co.com.sofka.domain.generic.Entity;

public class Consola extends Entity<ConsolaId> {

    protected Sistema sistema;
    protected Tipo tipo;
    protected Modelo modelo;
    protected Valor valor;


    public Consola(ConsolaId consolaId, Sistema sistema, Tipo tipo, Modelo modelo, Valor valor) {
        super(consolaId);
        this.sistema = sistema;
        this.tipo = tipo;
        this.modelo = modelo;
        this.valor = valor;
    }

    public void aplicarOferta(Valor valor){
        this.valor = (valor);
    }
}
