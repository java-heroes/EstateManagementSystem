package org.kodluyoruz.Ems.business.abstracts;

import org.kodluyoruz.Ems.entities.concretes.Seeker;
import java.util.List;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;

public interface SeekersService {
	DataResult<List<Seeker>> get();

	Result add(Seeker seeker);

	Result update(Seeker seeker);

	Result delete(Seeker seeker);

	DataResult<Seeker> getById(int id);
}