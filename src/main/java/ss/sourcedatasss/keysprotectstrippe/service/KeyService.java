package ss.sourcedatasss.keysprotectstrippe.service;

import ss.sourcedatasss.exceptions.KeyNotFoundException;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;


@Service
public record KeyService(String secretKey, String publicKey) {

    public KeyService() {
        this(loadSecretKey(), loadPublicKey());
        if (secretKey == null) {
            throw new KeyNotFoundException("La clave secreta no se encontró en la configuración.");
        }
        if (publicKey == null) {
            throw new KeyNotFoundException("La clave pública no se encontró en la configuración.");
        }
    }

    private static String loadSecretKey() {
        Dotenv dotenv = Dotenv.load();
        return dotenv.get("SECRETKEY");

    }

    private static String loadPublicKey() {
         Dotenv dotenv = Dotenv.load();
         return dotenv.get("PUBLICKEY");
    }
}
