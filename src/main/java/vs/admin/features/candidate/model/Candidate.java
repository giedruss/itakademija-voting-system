package vs.admin.features.candidate.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import vs.admin.features.admin.constituency.Constituency;
import vs.admin.features.party.model.Party;

@Entity
@Table(name = "candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "candidate_id")
	private Integer candidateID;

	@Column(name = "candidate_Name")
	private String candidateName;

	@Column(name = "candidate_Surname")
	private String candidateSurname;

	@Column(name = "candidate_DateOfBirth")
	private String candidateDateOfBirth; // Date or String???

	@Column(name = "candidate_PersonalID")
	private String candidatePersonalID;

	@Column(name = "candidate_Description")
	private String candidateDescription;
	/*-----------------------------------------------------------------*/
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidate_PartyId")
	private Party party;
	/*-----------------------------------------------------------------*/
	@Column(name = "candidate_NumberInParty")
	private Integer candidateNumberInParty;
	/*-----------------------------------------------------------------*/
	@OneToOne(cascade = CascadeType.ALL)						// cascade type perduoda veiksmus per visa range??
	@JoinColumn(name = "candidate_ConstituencyId")	// service kad rodytu istrintus tik pagal data
	private Constituency constituency;
	/*-----------------------------------------------------------------*/
	@Column(name = "candidate_DeletedDate")
	private Date candidateDeletedDate;

	public Candidate() {
	}

	public Candidate(Integer candidateID, String candidateName, String candidateSurname, String candidateDateOfBirth,
			String candidatePersonalID, String candidateDescription, Party party, Integer candidateNumberInParty,
			Constituency constituency, Date candidateDeletedDate) {
		super();
		this.candidateID = candidateID;
		this.candidateName = candidateName;
		this.candidateSurname = candidateSurname;
		this.candidateDateOfBirth = candidateDateOfBirth;
		this.candidatePersonalID = candidatePersonalID;
		this.candidateDescription = candidateDescription;
		this.party = party;
		this.candidateNumberInParty = candidateNumberInParty;
		this.constituency = constituency;
		this.candidateDeletedDate = candidateDeletedDate;
	}

	public Integer getCandidateID() {
		return candidateID;
	}

	public void setCandidateID(Integer candidateID) {
		this.candidateID = candidateID;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateSurname() {
		return candidateSurname;
	}

	public void setCandidateSurname(String candidateSurname) {
		this.candidateSurname = candidateSurname;
	}

	public String getCandidateDateOfBirth() {
		return candidateDateOfBirth;
	}

	public void setCandidateDateOfBirth(String candidateDateOfBirth) {
		this.candidateDateOfBirth = candidateDateOfBirth;
	}

	public String getCandidatePersonalID() {
		return candidatePersonalID;
	}

	public void setCandidatePersonalID(String candidatePersonalID) {
		this.candidatePersonalID = candidatePersonalID;
	}

	public String getCandidateDescription() {
		return candidateDescription;
	}

	public void setCandidateDescription(String candidateDescription) {
		this.candidateDescription = candidateDescription;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public Integer getCandidateNumberInParty() {
		return candidateNumberInParty;
	}

	public void setCandidateNumberInParty(Integer candidateNumberInParty) {
		this.candidateNumberInParty = candidateNumberInParty;
	}

	public Constituency getConstituency() {
		return constituency;
	}

	public void setConstituency(Constituency constituency) {
		this.constituency = constituency;
	}

	public Date getCandidateDeletedDate() {
		return candidateDeletedDate;
	}

	public void setCandidateDeletedDate(Date candidateDeletedDate) {
		this.candidateDeletedDate = candidateDeletedDate;
	}

}
