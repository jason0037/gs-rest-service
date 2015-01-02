package hello;

import hismartlife.wsdl.OpenLockResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LockingController {
	@Autowired
	private LockClient lockClient;
	
    @RequestMapping(value="/locks/{sn}",method=RequestMethod.GET)
    public @ResponseBody String locking(
    		@PathVariable(value="sn") String sn) {
    	String result = "";
    	try{
        	OpenLockResponse response = lockClient.openLock(sn);
        	if(response.getKssOpenResponseDto().getStatus().equals("ok"))
        	{
        		result = "0";
        	}else
        	{
        		result = "1";
        	}
        }catch(Exception e)
        {
        	result = "1";
        }
    	return result;
    }
}