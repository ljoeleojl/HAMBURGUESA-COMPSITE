/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;
import java.util.ArrayList;
import java.util.List;

/**
 * COMPOSITE – Nodo compuesto
 * Una hamburguesa contiene ingredientes (hojas u otras hamburguesas).
 * Es también el objeto que Builder ensambla y Prototype clona.
 */
public class Hamburguesa implements Ingrediente {

    private String nombre;
    private final List<Ingrediente> ingredientes = new ArrayList<>();

    public Hamburguesa(String nombre) {
        this.nombre = nombre;
    }

    /** Constructor copia profunda – PROTOTYPE */
    public Hamburguesa(Hamburguesa otra) {
        this.nombre = otra.nombre;
        for (Ingrediente ing : otra.ingredientes) {
            this.ingredientes.add(ing.clonar());   // clona cada hijo
        }
    }

    // ── Gestión de hijos (Composite) ─────────────────────────────────────
    public void agregar(Ingrediente ing)  { ingredientes.add(ing); }
    public void eliminar(Ingrediente ing) { ingredientes.remove(ing); }

    // ── Interfaz Ingrediente ─────────────────────────────────────────────
    @Override public String getNombre() { return nombre; }

    @Override
    public double getPrecio() {
        return ingredientes.stream().mapToDouble(Ingrediente::getPrecio).sum();
    }

    @Override
    public int getCalorias() {
        return ingredientes.stream().mapToInt(Ingrediente::getCalorias).sum();
    }

    @Override
    public String descripcion() {
        StringBuilder sb = new StringBuilder();
        sb.append("🍔 Hamburguesa: ").append(nombre).append("\n");
        for (Ingrediente ing : ingredientes) {
            sb.append(ing.descripcion()).append("\n");
        }
        sb.append("   ─────────────────────────────────────\n");
        sb.append(String.format("   TOTAL: $%.2f  |  %d kcal%n", getPrecio(), getCalorias()));
        return sb.toString();
    }

    /** PROTOTYPE – clon profundo */
    @Override
    public Ingrediente clonar() {
        return new Hamburguesa(this);
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
}
