package com.karthi.brms.repoimpli;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.karthi.brms.model.BikeType;
import com.karthi.brms.repo.BikeTypeRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BikeTypeRepoImpli implements BikeTypeRepo {
	EntityManager eManager;

	public BikeTypeRepoImpli(EntityManager eManager) {
		super();
		this.eManager = eManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllName() {
		String hql = "SELECT b.name FROM BikeType b";
		return eManager.createQuery(hql).getResultList();
	}

	@Override
	public BikeType findByName(String name) {
		String hql = "SELECT b FROM BikeType b where name = :name";
		return (BikeType) eManager.createQuery(hql).setParameter("name", name).getSingleResult();
	}

	@Override
	public BikeType save(BikeType bikeType) {
		eManager.persist(bikeType);
		return bikeType;
	}

	@Override
	public void deleteById(Long id) {
		BikeType bikeType = eManager.find(BikeType.class, id);
		eManager.remove(bikeType);
	}
	
}
