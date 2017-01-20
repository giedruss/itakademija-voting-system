package vs.admin.features.candidate.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateRepository {
	private static final String FIND_ALL = "SELECT x FROM Candidate x where candidate_Deleted_Date is NULL";

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Candidate> findAllCandidates() {
		return em.createQuery(FIND_ALL).getResultList();
	}

	/* ===================================================== */
	@Transactional
	public Candidate saveOrUpdateCandidateFParty(Candidate candidate) {
		if (candidate.getCandidateID() == null) {
			Candidate candidateParty = new Candidate(candidate.getCandidateID(), candidate.getCandidateName(),
					candidate.getCandidateSurname(), candidate.getCandidateDateOfBirth(),
					candidate.getCandidatePersonalID(), candidate.getCandidateDescription(), candidate.getParty(),
					candidate.getCandidateNumberInParty(), candidate.getCandidateDeletedDate());
			em.persist(candidateParty);
			return candidateParty;
		} else {
			Candidate merged = em.merge(candidate);
			em.persist(merged);
			return merged;
		}
	}

	@Transactional
	public Candidate saveOrUpdateCandidateFConstituency(Candidate candidate) {
		if (candidate.getCandidateID() == null) {
			Candidate candidateConstituency = new Candidate(candidate.getCandidateID(), candidate.getCandidateName(),
					candidate.getCandidateSurname(), candidate.getCandidateDateOfBirth(),
					candidate.getCandidatePersonalID(), candidate.getCandidateDescription(),
					candidate.getConstituency(), candidate.getCandidateDeletedDate());
			em.persist(candidateConstituency);
			return candidateConstituency;
		} else {
			Candidate merged = em.merge(candidate);
			em.persist(merged);
			return merged;
		}
	}

	/* ===================================================== */
	public Candidate findCandidateById(Integer id) {
		Candidate candidate = em.find(Candidate.class, id);
		if ((candidate != null) && (candidate.getCandidateDeletedDate() == null)) {
			return candidate;
		} else {
			return null;
		}
	}

	@Transactional
	public void deleteCandidateById(Integer id) {
		Candidate candidate = em.find(Candidate.class, id);
		Date date = new Date();
		candidate.setCandidateDeletedDate(date);
		em.persist(candidate);
	}

}

// validation
// junit
// integration
// documentation
