package org.launchcode.inventoryrest.Authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class AuthenticationController {

    @GetMapping(path = "/authentication")
    public UserAuthentication UserAuthentication() {
        return new UserAuthentication("You now have access");
    }

}