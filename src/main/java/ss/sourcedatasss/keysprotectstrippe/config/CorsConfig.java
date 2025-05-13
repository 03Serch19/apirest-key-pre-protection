package ss.sourcedatasss.keysprotectstrippe.config; 

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Aplica la configuración a las rutas bajo /api/
                        .allowedOrigins("http://127.0.0.1:5500") // Permite este origen
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                        .allowedHeaders("*") // Permite todos los encabezados
                        .allowCredentials(true) // Si se  necesita manejar cookies o autenticación
                        .maxAge(3600); // Tiempo de vida del preflight request (en segundos)
            }
        };
    }
}