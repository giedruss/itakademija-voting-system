package vs.admin.features.admin.district;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public District() {

	}

	public District(Integer id, String title, Long voters, String address) {
		this.id = id;
		this.title = title;
		this.voters = voters;
		this.address = address;
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
