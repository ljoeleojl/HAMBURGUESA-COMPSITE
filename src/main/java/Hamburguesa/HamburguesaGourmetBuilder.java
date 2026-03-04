/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;

/** BUILDER – Constructor concreto: Hamburguesa Gourmet */
public class HamburguesaGourmetBuilder implements HamburguesaBuilder {

    private final Hamburguesa hamburguesa = new Hamburguesa("Gourmet");

    @Override
    public HamburguesaBuilder agregarPan() {
        hamburguesa.agregar(new IngredienteSimple("Pan artesanal",  2.50, 140));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarCarne() {
        hamburguesa.agregar(new IngredienteSimple("Carne wagyu 200g", 9.00, 480));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarQueso() {
        hamburguesa.agregar(new IngredienteSimple("Queso brie",    1.50, 110));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarVerduras() {
        hamburguesa.agregar(new IngredienteSimple("Rúcula",              0.60,  4));
        hamburguesa.agregar(new IngredienteSimple("Tomate cherry",       0.50,  8));
        hamburguesa.agregar(new IngredienteSimple("Cebolla caramelizada",0.70, 45));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarSalsas() {
        hamburguesa.agregar(new IngredienteSimple("Salsa de trufa", 1.20, 60));
        return this;
    }

    @Override
    public HamburguesaBuilder agregarExtras() {
        hamburguesa.agregar(new IngredienteSimple("Tocino ahumado", 1.00, 90));
        hamburguesa.agregar(new IngredienteSimple("Huevo frito",    0.80, 78));
        return this;
    }

    @Override
    public Hamburguesa build() { return hamburguesa; }
}