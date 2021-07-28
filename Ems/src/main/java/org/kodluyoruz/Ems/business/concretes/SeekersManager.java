package org.kodluyoruz.Ems.business.concretes;

import java.util.List;
import org.kodluyoruz.Ems.business.abstracts.SeekersService;
import org.kodluyoruz.Ems.core.utilities.results.DataResult;
import org.kodluyoruz.Ems.core.utilities.results.ErrorResult;
import org.kodluyoruz.Ems.core.utilities.results.Result;
import org.kodluyoruz.Ems.core.utilities.results.SuccessDataResult;
import org.kodluyoruz.Ems.core.utilities.results.SuccessResult;
import org.kodluyoruz.Ems.dataAccess.abstracts.SeekerDao;
import org.kodluyoruz.Ems.entities.concretes.Seeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SeekersManager implements SeekersService {
	private SeekerDao seekerDao;

	@Autowired
	public SeekersManager(SeekerDao seekerDao) {
		super();
		this.seekerDao = seekerDao;
	}

	@Override
	public Result add(Seeker seeker) {
		Optional<Seeker> getSeeker = seekerDao.findById(seeker.getSeekersId());
		if (getSeeker.isPresent()) {
			return new ErrorResult("Such a seeker already exists");
		} else {
			this.seekerDao.save(seeker);
			return new SuccessResult("Adding successful");
		}
	}

	@Override
	public Result update(Seeker seeker) {
		Optional<Seeker> getSeeker = seekerDao.findById(seeker.getSeekersId());
		if (!getSeeker.isPresent()) {
			return new ErrorResult("There is no such seeker");
		} else {
			this.seekerDao.save(seeker);
			return new SuccessResult("Update Successful");
		}
	}

	@Override
	public Result delete(Seeker seeker) {
		this.seekerDao.deleteById(seeker.getSeekersId());
		return new SuccessResult("Deletion Successful.");
	}

	@Override
	public DataResult<Seeker> getById(int id) {
		return new SuccessDataResult<Seeker>(this.seekerDao.getById(id));
	}

	@Override
	public DataResult<List<Seeker>> get() {
		return new SuccessDataResult<List<Seeker>>(this.seekerDao.findAll(), "home seekers");
	}

}