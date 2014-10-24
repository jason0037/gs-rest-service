package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class LockConfiguration {
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("hismartlife.wsdl");
		return marshaller;
	}

	@Bean
	public LockClient lockClient(Jaxb2Marshaller marshaller) {
		LockClient client = new LockClient();
		client.setDefaultUri("http://121.40.69.254:8090/ws/kssLockService.wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
