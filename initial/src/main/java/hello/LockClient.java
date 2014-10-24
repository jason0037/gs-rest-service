package hello;


import hismartlife.wsdl.KssOpenRequestDto;
import hismartlife.wsdl.OpenLockRequest;
import hismartlife.wsdl.OpenLockResponse;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class LockClient extends WebServiceGatewaySupport {

	public OpenLockResponse openLock(String lockSn) {
		OpenLockRequest request = new OpenLockRequest();
		KssOpenRequestDto kssDto = new KssOpenRequestDto();
		kssDto.setLockAddress(lockSn);
		request.setKssOpenRequestDto(kssDto);

		OpenLockResponse response = (OpenLockResponse) getWebServiceTemplate().marshalSendAndReceive(
				request,
				new SoapActionCallback(
						"http://121.40.69.254:8090/ws/openLock"));
		return response;
	}
}