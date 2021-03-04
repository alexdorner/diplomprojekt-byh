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

    public static String getAll() {

        final String uri = "http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.189.51.8/api/method/login?usr=Administrator&pwd=12345678", String.class);
            String cookie;
            forEntity.getHeaders().get("Set-Cookie").stream().forEach(f ->{
            })
            ;
            for (String fe:forEntity.getHeaders().get("Set-Cookie")
            ) {
            if(fe.contains("sid")){
                return fe.split(";")[0];
            }
        }
        return "";
    }

}
