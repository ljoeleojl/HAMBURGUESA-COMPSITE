/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;
/**
 * COMPOSITE – Hoja (Leaf)
 * Ingrediente atómico: pan, carne, queso, lechuga…
 */
public class IngredienteSimple implements Ingrediente {

    private final String nombre;
    private final double precio;
    private final int    calorias;

    public IngredienteSimple(String nombre, double precio, int calorias) {
        this.nombre   = nombre;
        this.precio   = precio;
        this.calorias = calorias;
    }

    /** Constructor copia – PROTOTYPE */
    private IngredienteSimple(IngredienteSimple otro) {
        this(otro.nombre, otro.precio, otro.calorias);
    }

    @Override public String getNombre()  { return nombre; }
    @Override public double getPrecio()  { return precio; }
    @Override public int    getCalorias(){ return calorias; }

    @Override
    public String descripcion() {
        return String.format("   + %-22s  $%.2f  %d kcal", nombre, precio, calorias);
    }

    /** PROTOTYPE – clon superficial (campos son primitivos, seguro) */
    @Override
    public Ingrediente clonar() {
        return new IngredienteSimple(this);
    }
}