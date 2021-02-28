package byh.api.controller;



import org.apache.http.auth.Credentials;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/logindata")
@CrossOrigin
public class LoginDataController {

    @GetMapping
    public static Set<String>getAll() {

        final String uri = "http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678", String.class);
        Set<String> cookie = new HashSet<String>();
        forEntity.getHeaders().get("Set-Cookie").stream().forEach(f ->{
            if(f.contains("sid")){
                cookie.add(f);
            }
        });
     return cookie;
    }
//List<Session.Cookie>
}
