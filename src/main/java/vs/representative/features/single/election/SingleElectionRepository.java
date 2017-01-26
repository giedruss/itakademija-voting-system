package vs.representative.features.single.election;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class SingleElectionRepository {

	private static final String FIND_ALL = "SELECT x FROM SingleElection x WHERE single_deleted_date IS NULL";
//	private static final String FIND_BY_DISTRICT_ID = "SELECT x FROM SingleElection x WHERE singleDistrict IS ";
	
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<SingleElection> findAllSingleElectionResults() {
		return em.createQuery(FIND_ALL).getResultList();
	}

	@Transactional
	public SingleElection saveSingleElection(SingleElection singleElection) {
		if (singleElection.getSingleId() == null) {
			
			em.persist(singleElection);
			return singleElection;
		} 
		
		
		
		
		/*============Update====*/
		else {
			SingleElection merged = em.merge(singleElection);
			em.persist(merged);
			return merged;
		}

	}
	
	@Transactional
	public void publishSingleElectionResultById(Integer id) {
		SingleElection singleElection = em.find(SingleElection.class, id);
		Date date = new Date();
		singleElection.setSinglePublishedDate(date);
		em.persist(singleElection);
	}
	
//	@SuppressWarnings("null")
//	@Transactional
//	public List<SingleElection> publishSingleElectionResultByDistrictId(Integer id) {
//		@SuppressWarnings("unchecked")
//		List<SingleElection> bulkPublish = em.createQuery((FIND_BY_DISTRICT_ID+id)).getResultList();
//		List<SingleElection> rBulkPublish = null;
//		Date publishedDate = new Date();
//		for (SingleElection sE : bulkPublish) {
//			sE.setSinglePublishedDate(publishedDate);
//			rBulkPublish.add(sE); //suppressWarnings null
//		}
//		return rBulkPublish; //UPDATE TO HAVE PERSIST
//	}
	
	public SingleElection findSingleElectionById(Integer id) {
		SingleElection singleElection = em.find(SingleElection.class, id);
		if ((singleElection != null) && (singleElection.getSingleDeletedDate() == null)) {
			return singleElection;
		} else {
			return null;
		}
	}

//	@Transactional
//	public void deleteSingleElectionById(Integer id) {
//		SingleElection singleElection = em.find(SingleElection.class, id);
//		Date date = new Date();
//		singleElection.setSingleDeletedDate(date);
//		em.persist(singleElection);
//	}

}



