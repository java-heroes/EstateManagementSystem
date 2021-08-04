package org.kodluyoruz.Ems.core.utilities.adapters.MernisCheckAdapter;

import java.rmi.RemoteException;
import java.time.ZoneId;

import org.kodluyoruz.Ems.business.abstracts.RegisterCheckService;
import org.kodluyoruz.Ems.entities.concretes.Register;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter implements RegisterCheckService {
	public boolean CheckPerson(Register register) {
		KPSPublicSoap soapClient = new KPSPublicSoapProxy();
		boolean result = false ;
		
		try {
			
			result = soapClient.TCKimlikNoDogrula(Long.parseLong(register.getNationaltyidentity()), register.getFirstname().toUpperCase(), register.getLastname().toUpperCase(), register.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).getYear());
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
