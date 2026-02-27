package dao;

import conexion.Conexion;
import modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public void insertar(Empleado e) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO empleados(nombre,genero,cargo,fecha,foto) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getGenero());
            ps.setString(3, e.getCargo());
            ps.setDate(4, e.getFecha() != null ? new java.sql.Date(e.getFecha().getTime()) : null);
            ps.setBytes(5, e.getFoto());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        try (Connection con = Conexion.getConexion()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM empleados");
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setGenero(rs.getString("genero"));
                e.setCargo(rs.getString("cargo"));
                e.setFecha(rs.getDate("fecha"));
                e.setFoto(rs.getBytes("foto"));
                lista.add(e);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return lista;
    }

    public void actualizar(Empleado e) {
        try (Connection con = Conexion.getConexion()) {
            String sql = "UPDATE empleados SET nombre=?, genero=?, cargo=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getGenero());
            ps.setString(3, e.getCargo());
            ps.setInt(4, e.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void eliminar(int id) {
        try (Connection con = Conexion.getConexion()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM empleados WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
