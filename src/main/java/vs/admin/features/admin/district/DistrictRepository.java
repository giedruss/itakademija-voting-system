package vs.admin.features.admin.district;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DistrictRepository {

	private static final String FIND_ALL = "SELECT d from District d";

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<District> findAllDistricts() {
		return entityManager.createQuery(FIND_ALL).getResultList();
	}

	@Transactional
	public District saveOrUpdate(District district) {
		if (district.getId() == null) {
			entityManager.persist(district);
			return district;
		} else {
			District merged = entityManager.merge(district);
			entityManager.persist(merged);
			return merged;
		}
	}

}
