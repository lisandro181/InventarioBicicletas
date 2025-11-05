package modelo;

public class Bicicleta {
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int cantidad;

    public Bicicleta() {}

    public Bicicleta(String marca, String modelo, double precio, int cantidad) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {
        return id + " - " + marca + " " + modelo + " | Precio: " + precio + " | Stock: " + cantidad;
    }
}
