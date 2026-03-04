/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;
/**
 * BUILDER – Director
 * Conoce el orden correcto de los pasos y delega en el builder concreto.
 */
public class Cocina {

    private HamburguesaBuilder builder;

    public Cocina(HamburguesaBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(HamburguesaBuilder builder) {
        this.builder = builder;
    }

    /** Ensambla la hamburguesa completa (todos los pasos en orden). */
    public Hamburguesa construirCompleta() {
        return builder
                .agregarPan()
                .agregarCarne()
                .agregarQueso()
                .agregarVerduras()
                .agregarSalsas()
                .agregarExtras()
                .build();
    }

    /** Versión mínima: solo pan y carne. */
    public Hamburguesa construirMinima() {
        return builder
                .agregarPan()
                .agregarCarne()
                .build();
    }
}
