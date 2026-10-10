import java.util.Objects;
public class Computadora {
    private final String marca;
    private final String modelo;
    private final String procesador;
    private final int ram;
    private final String estado;
    public Computadora(String marca, String modelo, String procesador, int ram, String estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.procesador = procesador;
        this.ram = ram;
        this.estado = estado;
    }
    public String getMarca() {
        return marca;
    }
    public String getModelo() {
        return modelo;
    }
    public String getProcesador() {
        return procesador;
    }
    public int getRam() {
        return ram;
    }
    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " | Procesador: " + procesador + " | RAM: " + ram + "GB | Estado: " + estado;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Computadora computadora = (Computadora) o;
        return Objects.equals(marca, computadora.marca) && Objects.equals(modelo, computadora.modelo);
    }
    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo);
    }
}