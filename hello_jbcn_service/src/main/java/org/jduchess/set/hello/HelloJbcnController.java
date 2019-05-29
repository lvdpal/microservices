package org.jduchess.set.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloJbcnController {
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/hello", produces = "text/plain")
    public String sayHello() {
        return "Hello JBCN ";
    }
}
