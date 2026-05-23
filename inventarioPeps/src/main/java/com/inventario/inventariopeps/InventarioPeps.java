package com.inventario.inventariopeps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.inventario.model.Usuario;
import com.inventario.repository.UsuarioRepository;
/**
 *
 * @author Fredy
 */
@SpringBootApplication(scanBasePackages = "com.inventario")
@EnableJpaRepositories(basePackages = "com.inventario.repository")
@EntityScan(basePackages = "com.inventario.model")
public class InventarioPeps {

     public static void main(String[] args) {
        SpringApplication.run(InventarioPeps.class, args);
        System.out.println("========================================");
        System.out.println("APLICACION INICIADA");
        System.out.println("========================================");
    }
     @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository) {
        return args -> {
            // Usuarios con contraseñas en TEXTO PLANO
            if (!usuarioRepository.existsByEmail("admin@inventario.com")) {
                Usuario admin = new Usuario();
                admin.setNombreCompleto("Administrador Sistema");
                admin.setEmail("admin@inventario.com");
                admin.setContrasenaHash("admin123");  
                admin.setCarnetIdentidad("ADMIN001");
                admin.setRol("ADMINISTRADOR");
                usuarioRepository.save(admin);
                System.out.println("Usuario ADMIN: admin@inventario.com / admin123");
            }
            
            if (!usuarioRepository.existsByEmail("bodega@inventario.com")) {
                Usuario bodeguero = new Usuario();
                bodeguero.setNombreCompleto("Juan Bodeguero");
                bodeguero.setEmail("bodega@inventario.com");
                bodeguero.setContrasenaHash("bodega123"); 
                bodeguero.setCarnetIdentidad("BOD002");
                bodeguero.setRol("BODEGUERO");
                usuarioRepository.save(bodeguero);
                System.out.println("Usuario BODEGUERO: bodega@inventario.com / bodega123");
            }
            
            if (!usuarioRepository.existsByEmail("ventas@inventario.com")) {
                Usuario vendedor = new Usuario();
                vendedor.setNombreCompleto("Maria Vendedora");
                vendedor.setEmail("ventas@inventario.com");
                vendedor.setContrasenaHash("vende123");  
                vendedor.setCarnetIdentidad("VEN003");
                vendedor.setRol("VENDEDOR");
                usuarioRepository.save(vendedor);
                System.out.println("Usuario VENDEDOR: ventas@inventario.com / vende123");
            }
        };
    }
}
