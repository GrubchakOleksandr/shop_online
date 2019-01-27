package service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import java.sql.SQLException;

import dao.BucketDao;
import dao.impl.BucketDaoImpl;
import domain.Bucket;
import service.BucketService;

public class BucketServiceImpl implements BucketService {
	private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
	private static BucketService bucketServiceImlp;

	private BucketDao bucketDao;

	public BucketServiceImpl() {

		try {
			bucketDao = new BucketDaoImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			LOGGER.error(e);
		}
	}

	public static BucketService getBucketService() {
		if (bucketServiceImlp == null) {
			bucketServiceImlp = new BucketServiceImpl();
		}
		return bucketServiceImlp;
	}

	@Override
	public Bucket create(Bucket t) {
		return bucketDao.create(t);
	}

	@Override
	public Bucket read(Integer id) {
		return bucketDao.read(id);
	}

	@Override
	public Bucket update(Bucket t) {
		return bucketDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		bucketDao.delete(id);
	}

	@Override
	public List<Bucket> readAll() {
		return bucketDao.readAll();
	}

}
