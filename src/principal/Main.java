package principal;

import modelo.Bicicleta;

import java.BicicletaDAO;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BicicletaDAO dao = new BicicletaDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nINVENTARIO TIENDA DE BICICLETAS");
            System.out.println("1. Agregar bicicleta");
            System.out.println("2. Listar bicicletas");
            System.out.println("3. Eliminar bicicleta");
            System.out.println("4. Actualizar stock");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    dao.agregarBicicleta(new Bicicleta(marca, modelo, precio, cantidad));
                }
                case 2 -> {
                    List<Bicicleta> lista = dao.listarBicicletas();
                    System.out.println("Lista de bicicletas");
                    lista.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("ID de la bicicleta a eliminar: ");
                    int id = sc.nextInt();
                    dao.eliminarBicicleta(id);
                }
                case 4 -> {
                    System.out.print("ID de la bicicleta: ");
                    int id = sc.nextInt();
                    System.out.print("Nuevo stock: ");
                    int nuevoStock = sc.nextInt();
                    dao.actualizarStock(id, nuevoStock);
                }
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }
}
