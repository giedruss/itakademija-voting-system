package vs.admin.features.party.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "parties")
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "party_id")
	private Integer id;

	@Column(name = "party_title")
	private String title;
	
	@Column(name = "party_abbreviation")
	//@Size(max=10)
	private String party_abbreviation;

	@Column(name = "deleted_date")
	private Date deletedTime;
	
	public Party() {

	}

	public Party(Integer id, String title, Date deletedTime) {
		this.id = id;
		this.title = title;
		this.deletedTime = deletedTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}
	
	public Date getDeletedTime() {
		return deletedTime;
	}

	public String getParty_abbreviation() {
		return party_abbreviation;
	}

	public void setParty_abbreviation(String party_abbreviation) {
		this.party_abbreviation = party_abbreviation;
	}

	
}
