package Entities;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArticuloInsumoDAO {

    public ArticuloInsumo getArticuloInsumobyId(Connection connection, int id) throws SQLException {
        String sqlSelect = "SELECT * FROM articulos_insumo WHERE id=?";
        try (PreparedStatement psSelect = connection.prepareStatement(sqlSelect)) {
            psSelect.setInt(1, id);
            try (ResultSet rs = psSelect.executeQuery()) {
                if (rs.next()) {
                    return new ArticuloInsumo().builder()
                            .id(rs.getInt("id"))
                            .denominacion(rs.getString("denominacion"))
                            .stockActual(rs.getInt("stock"))
                            .precioCompra(rs.getDouble("precio_compra"))
                            .build();
                }
            }
        }
        return null;
    }

    public Set<ArticuloInsumo> getAllArticulosInsumo(Connection connection) throws  SQLException{
        String sqlSelect = "SELECT * FROM articulos_insumo";
        Set<ArticuloInsumo> listaInsumos = new HashSet<>();
        try (PreparedStatement psSelect = connection.prepareStatement(sqlSelect)) {
            ResultSet rs = psSelect.executeQuery();
            while (rs.next()){
                ArticuloInsumo insumo = ArticuloInsumo.builder()
                        .id(rs.getInt("id"))
                        .denominacion(rs.getString("denominacion"))
                        .stockActual(rs.getInt("stock"))
                        .precioCompra(rs.getDouble("precio_compra"))
                        .build();
                listaInsumos.add(insumo);
            }
        }
        return listaInsumos;
    }

    public void guardarInsumo(Connection conex, ArticuloInsumo insumo) throws SQLException {
        String sqlInsert = "INSERT INTO articulos_insumo (id, denominacion, stock, precio_compra) VALUES (?, ?, ?, ?)";

        try (PreparedStatement psInsert = conex.prepareStatement(sqlInsert)) {
            psInsert.setInt(1, insumo.getId());
            psInsert.setString(2, insumo.getDenominacion());
            psInsert.setInt(3, insumo.getStockActual());
            psInsert.setDouble(4, insumo.getPrecioCompra());
            int filasInsertadas = psInsert.executeUpdate();
            System.out.println("🔵 Filas insertadas: " + filasInsertadas);
        }
    }

    public void update(Connection conex, ArticuloInsumo insumo) throws SQLException {
        String sqlUpdate = "UPDATE articulo_insumo denominacion = ?, stock = , precio_compra= ? WHERE id = ?";

        try (PreparedStatement psUpdate = conex.prepareStatement(sqlUpdate)) {
            psUpdate.setString(1, insumo.getDenominacion());
            psUpdate.setInt(2, insumo.getStockActual());
            psUpdate.setDouble(3, insumo.getPrecioCompra());
            psUpdate.setInt(4, insumo.getId());
            int filasActualizadas = psUpdate.executeUpdate();
            System.out.println("🟡 Filas actualizadas: " + filasActualizadas);
        }
    }

    public void delete(Connection conex, int id) throws SQLException {
        String sqlDelete = "DELETE FROM articulos_insumo WHERE id = ?";

        try (PreparedStatement psDelete = conex.prepareStatement(sqlDelete)) {
            psDelete.setInt(1, id);
            int filasEliminadas = psDelete.executeUpdate();
            System.out.println("🔴 Filas eliminadas: " + filasEliminadas);
        }
    }
}
