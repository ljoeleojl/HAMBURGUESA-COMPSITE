package iofactory.client;

import Hamburguesa.Cocina;
import Hamburguesa.HamburguesaClasicaBuilder;
import Hamburguesa.HamburguesaGourmetBuilder;
import Hamburguesa.Hamburguesa;
import Hamburguesa.IngredienteSimple;
import Hamburguesa.RegistroPrototipos;
import iofactory.adapter.DataAdapter;
import iofactory.adapter.DefaultDataAdapter;
import iofactory.factory.ConsoleFactory;
import iofactory.factory.DialogFactory;
import iofactory.factory.IOFactory;
import iofactory.factory.WebFactory;
import iofactory.input.Input;
import iofactory.output.Output;

import java.time.LocalDateTime;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // ── 1. Abstract Factory: elige entorno de I/O (igual que el original) ─
        IOFactory ioFactory = elegirFactory();
        Input  input  = ioFactory.createInput();
        Output output = ioFactory.createOutput();
        DataAdapter adapter = new DefaultDataAdapter();   // adapter original

        // ── 2. BUILDER: construye los prototipos del menú ─────────────────────
        Cocina cocina = new Cocina(new HamburguesaClasicaBuilder());
        Hamburguesa plantillaClasica = cocina.construirCompleta();

        cocina.setBuilder(new HamburguesaGourmetBuilder());
        Hamburguesa plantillaGourmet = cocina.construirCompleta();

        // ── 3. PROTOTYPE: registra plantillas ─────────────────────────────────
        RegistroPrototipos registro = new RegistroPrototipos();
        registro.registrar("clasica", plantillaClasica);
        registro.registrar("gourmet", plantillaGourmet);

        // ── 4. Muestra el menú ────────────────────────────────────────────────
        output.write("╔══════════════════════════════════════╗");
        output.write("║        MENÚ DE HAMBURGUESAS          ║");
        output.write("╚══════════════════════════════════════╝");
        output.write(plantillaClasica.descripcion());
        output.write(plantillaGourmet.descripcion());

        // ── 5. Pedido del cliente: clon + personalización ─────────────────────
        String tipo = input.read("¿Qué hamburguesa desea? (clasica / gourmet)");
        String nombre = input.read("¿Nombre del cliente?");

        Hamburguesa pedido = registro.clonar(tipo.trim().toLowerCase());
        pedido.setNombre("Pedido de " + nombre);

        // Personalización sobre el clon (no afecta la plantilla)
        String extra = input.read("¿Ingrediente extra? (enter para omitir)");
        if (!extra.isBlank()) {
            pedido.agregar(new IngredienteSimple(extra, 0.50, 20));
        }

        // ── 6. Muestra el pedido final usando el adapter original ─────────────
        output.write("\n── Tu pedido ─────────────────────────");
        output.write(adapter.toText(pedido.getNombre()));
        output.write(pedido.descripcion());
        output.write("Precio total: " + adapter.toText(pedido.getPrecio()));
        output.write("Calorías:     " + adapter.toText(pedido.getCalorias()));
    }

    // ── Selección de fábrica (idéntico al App original) ──────────────────
    private static IOFactory elegirFactory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione entorno:");
        System.out.println("1) Consola");
        System.out.println("2) Ventana (JOptionPane)");
        System.out.println("3) Web (simulada)");
        System.out.print("> ");
        return switch (sc.nextLine().trim()) {
            case "2" -> new DialogFactory();
            case "3" -> new WebFactory();
            default  -> new ConsoleFactory();
        };
    }
}