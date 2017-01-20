package vs.representative.features.single.election;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import vs.admin.features.admin.constituency.Constituency;
import vs.admin.features.candidate.model.Candidate;

@Entity
@Table(name = "single_member_votes")
public class SingleElection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "single_id")
	private Integer singleId;

	@Column(name = "single_votes")
	private Integer singleVotes;

	@Column(name = "single_entered_date")
	private Date singleEnteredDate;

	@Column(name = "single_published_date")
	private Date singlePublishedDate;

	@Column(name = "single_deleted_date")
	private Date singleDeletedDate;
	/* ====================================== */
	@OneToOne // (cascade = CascadeType.ALL) when creating a vote you fill the
				// data but do not perform operations on other tables
	@JoinColumn(name = "single_Candidate")
	private Candidate singleCandidate;

	@OneToOne // (cascade = CascadeType.ALL) when creating a vote you fill the
				// data but do not perform operations on other tables
	@JoinColumn(name = "single_Constituency")
	private Constituency singleConstituency;
	/* ====================================== */

	public SingleElection() {
	}

	
	
	public SingleElection(Integer singleId, Integer singleVotes, /*Date singleEnteredDate,*/ /*Date singlePublishedDate,*/
			Date singleDeletedDate, Candidate singleCandidate, Constituency singleConstituency) {
		super();
		this.singleId = singleId;
		this.singleVotes = singleVotes;
		/*this.singleEnteredDate = singleEnteredDate;*/
		/*this.singlePublishedDate = singlePublishedDate;*/
		this.singleDeletedDate = singleDeletedDate;
		this.singleCandidate = singleCandidate;
		this.singleConstituency = singleConstituency;
	}



	public Integer getSingleId() {
		return singleId;
	}

	public void setSingleId(Integer singleId) {
		this.singleId = singleId;
	}

	public Integer getSingleVotes() {
		return singleVotes;
	}

	public void setSingleVotes(Integer singleVotes) {
		this.singleVotes = singleVotes;
	}

	public Date getSingleEnteredDate() {
		return singleEnteredDate;
	}

	public void setSingleEnteredDate(Date singleEnteredDate) {
		this.singleEnteredDate = singleEnteredDate;
	}

	public Date getSinglePublishedDate() {
		return singlePublishedDate;
	}

	public void setSinglePublishedDate(Date singlePublishedDate) {
		this.singlePublishedDate = singlePublishedDate;
	}

	public Date getSingleDeletedDate() {
		return singleDeletedDate;
	}

	public void setSingleDeletedDate(Date singleDeletedDate) {
		this.singleDeletedDate = singleDeletedDate;
	}

	public Candidate getSingleCandidate() {
		return singleCandidate;
	}

	public void setSingleCandidate(Candidate singleCandidate) {
		this.singleCandidate = singleCandidate;
	}

	public Constituency getSingleConstituency() {
		return singleConstituency;
	}

	public void setSingleConstituency(Constituency singleConstituency) {
		this.singleConstituency = singleConstituency;
	}
}
