package casodeestudio.model.Clientes;
//Basicamente este cosito lo que hace es que crea un array list para guardar los nombres y datos de los clientes, por que? porque así vi yo que iba a ser
//más fácil para no hacerla más larga, y ya depúes ah sabes que como compruebo de el cliente esta logeado o pues registrado; entonces por eso tiene el 
//metodo booleano que le retorna eso pues o sea decirle como, mira este cliente tal esta registrado o no? si no mandame false, básico pues. Pero no se si 
//le faltara algo mas 
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    // Método para registrar clientes en una lista
    public static ArrayList<Cliente> registrarClientes() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        System.out.print("¿Cuántos clientes desea ingresar? ");
        int cantidad = sc.nextInt();
        sc.nextLine(); // limpiar el buffer

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el nombre del cliente #" + (i+1) + ": ");
            String nombre = sc.nextLine();

            System.out.print("Ingrese la dirección: ");
            String direccion = sc.nextLine();

            System.out.print("Ingrese el teléfono: ");
            String telefono = sc.nextLine();

            // Crear objeto Cliente con constructor
            Cliente cliente = new Cliente(nombre, direccion, telefono);
            clientes.add(cliente);
        }

        System.out.println("\nLista de clientes registrados:");
        for (Cliente c : clientes) {
            System.out.println("Nombre: " + c.getNombre() +
                    ", Dirección: " + c.getDireccion() +
                    ", Teléfono: " + c.getTelefono());
        }

        return clientes;
    }

    // Método para consultar si un cliente está registrado por nombre
    public static boolean consultarCliente(ArrayList<Cliente> clientes, String nombre) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return true; // Cliente encontrado
            }
        }
        return false; // Cliente no encontrado
    }

    // Método main para probar
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = Cliente.registrarClientes();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngrese el nombre del cliente a consultar: ");
        String consulta = sc.nextLine();

        if (Cliente.consultarCliente(listaClientes, consulta)) {
            System.out.println("El cliente SÍ está registrado.");
        } else {
            System.out.println("El cliente NO está registrado.");
        }

        sc.close();
    }
}


