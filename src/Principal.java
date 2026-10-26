public class Principal {
    public static void main(String[] args) {
        System.out.println("Iniciando pruebas del módulo...\n");
        
        UsuarioDAO dao = new UsuarioDAO();
        
        // Probar actualizar el usuario con ID 1
        // dao.actualizarUsuario(1, "Tatiana Rios", "tatiana.rios@sena.edu.co");
        
        // Probar eliminar un usuario por su ID (ej: ID 3)
        // dao.eliminarUsuario(3);
        
        // Consultar la lista final
        dao.consultarUsuarios();
    }
}