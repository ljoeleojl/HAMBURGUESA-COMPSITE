/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;
/** BUILDER – Constructor concreto: Hamburguesa Clásica */
public class HamburguesaClasicaBuilder implements HamburguesaBuilder {

    private final Hamburguesa hamburguesa = new Hamburguesa("Clásica");

    @Override
    public HamburguesaBuilder agregarPan() {
        hamburguesa.agregar(new IngredienteSimple("Pan brioche",   1.50, 120));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarCarne() {
        hamburguesa.agregar(new IngredienteSimple("Carne res 150g", 4.00, 350));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarQueso() {
        hamburguesa.agregar(new IngredienteSimple("Queso cheddar", 0.80, 90));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarVerduras() {
        hamburguesa.agregar(new IngredienteSimple("Lechuga",  0.30,  5));
        hamburguesa.agregar(new IngredienteSimple("Tomate",   0.30, 10));
        hamburguesa.agregar(new IngredienteSimple("Cebolla",  0.20,  8));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarSalsas() {
        hamburguesa.agregar(new IngredienteSimple("Ketchup",  0.20, 30));
        hamburguesa.agregar(new IngredienteSimple("Mostaza",  0.20, 20));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarExtras() {
        return this; // sin extras en la clásica
    }

    @Override
    public Hamburguesa build() { return hamburguesa; }
}
