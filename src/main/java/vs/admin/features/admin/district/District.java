package vs.admin.features.admin.district;

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

import vs.admin.features.admin.representative.Representative;

@Entity
@Table(name = "districts")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "district_id")
	private Integer id;

	@Column(name = "district_title")
	private String title;

	@Column(name = "number_of_voters")
	private Long voters;

	@Column(name = "district_address")
	private String address;

	@Column(name = "deleted_date")
	private Date deletedTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "district_id")
	private Representative representative;

	public District() {

	}

	public District(Integer id, String title, Long voters, String address, Date deleteTime) {
		this.id = id;
		this.title = title;
		this.voters = voters;
		this.address = address;
		this.deletedTime = deleteTime;

	}

	public Representative getRepresentative() {
		return representative;
	}

	public void setRepresentative(Representative representative) {
		this.representative = representative;
	}

	public Date getDeletedTime() {
		return deletedTime;
	}

	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Long getVoters() {
		return voters;
	}

	public void setVoters(Long voters) {
		this.voters = voters;
	}

}
