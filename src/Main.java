import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner consola = new Scanner(System.in);
    private static List<Persona> personas = new ArrayList<>();
    static int opcionElegida;

    public static void main(String[] args) {

        System.out.println("****Listado de Personas**** \n");

        try {
            do {
                mostrarMenu();
                opcionElegida = consola.nextInt();
                System.out.println("Elegiste la opción = " + opcionElegida + "\n");
                seleccionarMenu(opcionElegida);
            } while (opcionElegida >= 1 && opcionElegida < 3);
        } catch (Exception e) {
            System.out.println("El carácter introducido no es un número...  ");
        }

    }

    private static void mostrarMenu() {
        System.out.println("¿Qué desea hacer? \n");
        System.out.println("1.Agregar persona en la lista 2.Mostrar personas contenidas en la lista 3.Salir \n");
        System.out.println("Escoge una opción = ");

    }

    private static void seleccionarMenu(int opcionElegida) {

        switch (opcionElegida) {
            case 1:
                crearPersona();
                break;
            case 2:
                mostrarPersonas();
                break;
            case 3:
                System.out.println("Hasta la próxima!... =)");
                System.exit(0);
                break;
            default:
                throw new IllegalArgumentException("Opción no válida" + opcionElegida);
        }

    }

    private static void crearPersona() {

        System.out.println("Introduce el nombre de la persona:");
        String nombre = consola.next();
        System.out.println("Introduce el número de teléfono de la persona:");
        String tel = consola.next();
        System.out.println("Introduce el email de la persona:");
        String email = consola.next();

        Persona persona = new Persona(nombre, tel, email);

        personas.add(persona);

    }

    private static void mostrarPersonas() {

        int tamañoTotal = personas.size();
        System.out.println("El tamaño de la lista es de " + tamañoTotal + " personas \n");

        personas.forEach(persona -> {
            System.out.println("Persona creada " + persona.getNombre() + ", con número de teléfono = "
                    + persona.getTel() + ", con dirección de correo electrónico = " + persona.getEmail());
        });

        System.out.println();

    }
}