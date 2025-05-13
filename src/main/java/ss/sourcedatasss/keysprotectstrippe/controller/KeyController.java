package ss.sourcedatasss.keysprotectstrippe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ss.sourcedatasss.keysprotectstrippe.service.KeyService;

@RestController
@RequestMapping("/api/v1/key")
public class KeyController {
//@Autowired//no valido para instancias finales
private final KeyService keyService;
   public KeyController(KeyService keyService) {
        this.keyService = keyService;
    }

  @GetMapping("/secret")
  public ResponseEntity<Map<String, String>> getSecret() {
    Map<String, String> respuesta = new HashMap<>();
    respuesta.put("k", keyService.secretKey());
    return ResponseEntity.ok(respuesta);
  }

  @GetMapping("/public")
  public ResponseEntity<Map<String, String>> getPublic() {
    Map<String, String> respuesta = new HashMap<>();
    respuesta.put("k", keyService.publicKey());
    return ResponseEntity.ok(respuesta);
  }

}
