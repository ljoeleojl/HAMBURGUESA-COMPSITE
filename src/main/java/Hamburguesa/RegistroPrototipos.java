/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamburguesa;

import java.util.HashMap;
import java.util.Map;
/**
 * PROTOTYPE – Registro de prototipos
 * Almacena hamburguesas-plantilla (construidas por Builder) y entrega
 * clones profundos bajo demanda, sin reconstruir desde cero.
 */
public class RegistroPrototipos {

    private final Map<String, Hamburguesa> catalogo = new HashMap<>();

    public void registrar(String clave, Hamburguesa prototipo) {
        catalogo.put(clave, prototipo);
    }

    /**
     * Devuelve un clon profundo del prototipo registrado bajo {@code clave}.
     * @throws IllegalArgumentException si la clave no existe.
     */
    public Hamburguesa clonar(String clave) {
        Hamburguesa proto = catalogo.get(clave);
        if (proto == null)
            throw new IllegalArgumentException("Prototipo no encontrado: " + clave);
        return (Hamburguesa) proto.clonar();
    }
}
