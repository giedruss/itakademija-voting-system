package vs.admin.features.admin.representative;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "representatives")
public class Representative {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "representative_id")
	private Integer id;

	@Column(name = "representative_name")
	private String name;

	@Column(name = "representative_surname")
	private String surname;

	// @UniqueConstraint
	@Column(name = "representative_loginname")
	private String loginName;

	@Column(name = "representative_password")
	private String password;

	@Column(name = "representative_email")
	private String email;

	@Column(name = "deleted_date")
	private Date deletedTime;

	@Column(name = "district_id")
	private Integer districtId;

	public Representative() {

	}

	public Representative(Integer id, String name, String surname, String loginName, String password, String email,
			Date deletedTime, Integer districtId) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.loginName = loginName;
		this.password = password;
		this.email = email;
		this.deletedTime = deletedTime;
		this.districtId = districtId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDeletedTime() {
		return deletedTime;
	}

	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

}

/*
 * 
 * Based on: FR3 Acceptance:
 * 
 * data entered is using extended “apylinkes atstovo duomenu modelis” admin can
 * select district for which the data will be entered admin can enter district
 * representatives data after selecting a district admin can view district
 * representatives data admin can delete district representatives admin can edit
 * district representatives Validation: administrator can enter only those
 * districts that are in the district list district - singular entry UI alert
 * informs if the data is already entered Backend doesn’t allow data repetition
 * Input fields do not accept non character symbols except dash and @. Out of
 * Scope: -functionality Administrator can give access to the system
 * (login(email, password))
 * 
 */