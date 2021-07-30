package org.kodluyoruz.Ems.core.utilities.adapters.mernisServiceAdapter;

import java.rmi.RemoteException;

import org.kodluyoruz.Ems.core.utilities.adapters.service.MernisCheckService;
import org.kodluyoruz.Ems.entities.concretes.Register;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisAdapter implements MernisCheckService {

	@Override
	public boolean Control(Register register) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(register.getNationaltyidentity()), 
						register.getFirstname(), 
						register.getLastname(), 
						register.getDateofbirth().toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}


}
