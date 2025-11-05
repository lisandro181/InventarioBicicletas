package dao;

import modelo.Bicicleta;
import database.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BicicletaDAO {

    public void agregarBicicleta(Bicicleta b) {
        String sql = "INSERT INTO bicicletas (marca, modelo, precio, cantidad) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, b.getMarca());
            ps.setString(2, b.getModelo());
            ps.setDouble(3, b.getPrecio());
            ps.setInt(4, b.getCantidad());
            ps.executeUpdate();
            System.out.println("Bicicleta agregada");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public List<Bicicleta> listarBicicletas() {
        List<Bicicleta> lista = new ArrayList<>();
        String sql = "SELECT * FROM bicicletas";
        try (Connection con = Conexion.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Bicicleta b = new Bicicleta();
                b.setId(rs.getInt("id"));
                b.setMarca(rs.getString("marca"));
                b.setModelo(rs.getString("modelo"));
                b.setPrecio(rs.getDouble("precio"));
                b.setCantidad(rs.getInt("cantidad"));
                lista.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return lista;
    }

    public void eliminarBicicleta(int id) {
        String sql = "DELETE FROM bicicletas WHERE id = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Bicicleta eliminada");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void actualizarStock(int id, int nuevoStock) {
        String sql = "UPDATE bicicletas SET cantidad = ? WHERE id = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nuevoStock);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Stock actualizado");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
