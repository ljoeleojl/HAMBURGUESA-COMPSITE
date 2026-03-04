/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;

/**
 * COMPOSITE – Componente
 * Interfaz común para ingredientes simples (hojas) y la hamburguesa (nodo).
 */
public interface Ingrediente {
    String getNombre();
    double getPrecio();
    int    getCalorias();
    String descripcion();

    /** PROTOTYPE – gancho de clonación */
    Ingrediente clonar();
}