package hello;

import hismartlife.wsdl.OpenLockResponse;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
	@Autowired
	private LockClient lockClient;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public @ResponseBody Greeting greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        OpenLockResponse response = lockClient.openLock("05175a0f");
        System.out.println(response);
    	return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}