/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;

public interface HamburguesaBuilder {
    HamburguesaBuilder agregarPan();
    HamburguesaBuilder agregarCarne();
    HamburguesaBuilder agregarQueso();
    HamburguesaBuilder agregarVerduras();
    HamburguesaBuilder agregarSalsas();
    HamburguesaBuilder agregarExtras();
    Hamburguesa build();
}
