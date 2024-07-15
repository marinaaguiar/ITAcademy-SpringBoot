package cat.itacademy.barcelonactiva.alecrim.marina.s04.t01.n02.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String greets(@RequestParam(defaultValue = "UNKNOWN") String name) {
        return "Hello, " + name + ". You are running a Gradle project";
    }

    @GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{name}"})
    public String greets2(@PathVariable(required = false) String name) {
        if (name == null) {
            name = "UNKNOWN";
        }
        return "Hello, " + name + ". You are running a Gradle project";
    }
}
