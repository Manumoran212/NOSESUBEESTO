import java.util.Scanner;
public class Main {
    static SinglyLinkedList<Computadora> computadoras = new SinglyLinkedList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Taller de Computadoras");
            System.out.println("1. Agregar computadora");
            System.out.println("2. Mostrar computadoras");
            System.out.println("3. Eliminar computadora");
            System.out.println("4. Buscar computadora");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> agregarComputadora();
                case 2 -> mostrarComputadoras();
                case 3 -> eliminarComputadora();
                case 4 -> buscarComputadora();
                case 0 -> System.out.println("Adios.");
                default -> System.out.println("Opción no válida");
            }
        } while (option != 0);
    }

    private static void agregarComputadora() {
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        System.out.print("Modelo: ");
        String modelo = sc.nextLine();
        System.out.print("Procesador: ");
        String procesador = sc.nextLine();
        System.out.print("RAM (GB): ");
        int ram = sc.nextInt();
        sc.nextLine();
        System.out.print("Estado (Disponible/En reparación/Vendida): ");
        String estado = sc.nextLine();

        Computadora nuevaComputadora = new Computadora(marca, modelo, procesador, ram, estado);
        computadoras.insertLast(nuevaComputadora);
        System.out.println("Computadora " + marca + " " + modelo + " agregada correctamente.");
    }

    private static void mostrarComputadoras() {
        if (computadoras.isEmpty()) {
            System.out.println("No hay computadoras registradas.");
            return;
        }

        System.out.println("Computadoras del Taller");
        int contador = 1;
        Node<Computadora> current = computadoras.head;

        while (current != null) {
            Computadora c = current.getData();
            System.out.println(contador + ". " + c);
            current = current.getNext();
            contador++;
        }
    }

    private static void eliminarComputadora() {
        if (computadoras.isEmpty()) {
            System.out.println("No hay computadoras para eliminar.");
            return;
        }

        mostrarComputadoras();
        System.out.print("Marca de la computadora a eliminar: ");
        String marca = sc.nextLine();
        System.out.print("Modelo de la computadora a eliminar: ");
        String modelo = sc.nextLine();

        Computadora computadoraAEliminar = new Computadora(marca, modelo, "", 0, "");
        if (computadoras.remove(computadoraAEliminar)) {
            System.out.println("Computadora eliminada correctamente.");
        } else {
            System.out.println("La computadora no existe.");
        }
    }

    private static void buscarComputadora() {
        if (computadoras.isEmpty()) {
            System.out.println("No hay computadoras para buscar.");
            return;
        }

        System.out.print("Marca a buscar: ");
        String marca = sc.nextLine();
        System.out.print("Modelo a buscar: ");
        String modelo = sc.nextLine();

        Node<Computadora> current = computadoras.head;
        boolean encontrada = false;

        while (current != null) {
            Computadora c = current.getData();
            if (c.getMarca().equalsIgnoreCase(marca) && c.getModelo().equalsIgnoreCase(modelo)) {
                System.out.println("Computadora encontrada:");
                System.out.println(c);
                encontrada = true;
                break;
            }
            current = current.getNext();
        }

        if (!encontrada) {
            System.out.println("La computadora no existe en el taller.");
        }
    }
}