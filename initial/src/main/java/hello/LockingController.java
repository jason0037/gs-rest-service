package hello;

import hismartlife.wsdl.OpenLockResponse;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LockingController {
	@Autowired
	private LockClient lockClient;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/locking")
    public @ResponseBody Locking greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
        OpenLockResponse response = lockClient.openLock("05175a0f");
    	return new Locking("success");
    }
}