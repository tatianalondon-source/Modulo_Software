import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    // 1. INSERCIÓN (Crear)
    public void insertarUsuario(String nombre, String correo) {
        String sql = "INSERT INTO usuarios (nombre, correo) VALUES (?, ?)";
        
        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.executeUpdate();
            System.out.println("¡Usuario registrado con éxito!");
            
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    // 2. CONSULTA (Leer)
    public void consultarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        
        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.println("\n--- LISTA DE USUARIOS ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                System.out.println("ID: " + id + " | Nombre: " + nombre + " | Correo: " + correo);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar usuarios: " + e.getMessage());
        }
    }

    // 3. ACTUALIZACIÓN (Update)
    public void actualizarUsuario(int id, String nuevoNombre, String nuevoCorreo) {
        String sql = "UPDATE usuarios SET nombre = ?, correo = ? WHERE id = ?";
        
        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setString(1, nuevoNombre);
            ps.setString(2, nuevoCorreo);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("¡Usuario actualizado con éxito!");
            
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    // 4. ELIMINACIÓN (Delete)
    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        
        try (Connection conexion = Conexion.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("¡Usuario eliminado con éxito!");
            
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}