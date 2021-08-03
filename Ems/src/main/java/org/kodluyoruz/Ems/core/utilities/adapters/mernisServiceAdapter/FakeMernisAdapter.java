package org.kodluyoruz.Ems.core.utilities.adapters.mernisServiceAdapter;

import org.kodluyoruz.Ems.core.utilities.adapters.service.MernisCheckService;
import org.kodluyoruz.Ems.entities.concretes.Register;

//for test
public class FakeMernisAdapter implements MernisCheckService {

	@Override
	public boolean Control(Register register) {
		return true;//default true method
	}

}
