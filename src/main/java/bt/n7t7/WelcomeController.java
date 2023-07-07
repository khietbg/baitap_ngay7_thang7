package bt.n7t7;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/welcome/index")
    public ResponseEntity<?> welcome(@RequestParam("name") String name) {
        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}
