package com.hcl.bb.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bb_user")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private long userId;
	@Column(name = "USER_NAME", length = 25, nullable = false)
	private String userName;
	@Column(name = "USER_PASSWD", length = 25, nullable = false)
	private String password;
	@Transient
	private String confirmPassword;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<RequestBlood> requestBlood = new LinkedList<RequestBlood>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<DonateBlood> donateBlood = new LinkedList<DonateBlood>();

	public User() {
		super();
	}

	public User(long userId, String userName, String password, String confirmPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<RequestBlood> getRequestBlood() {
		return requestBlood;
	}

	public void setRequestBlood(List<RequestBlood> requestBlood) {
		this.requestBlood = requestBlood;
	}

	public List<DonateBlood> getDonateBlood() {
		return donateBlood;
	}

	public void setDonateBlood(List<DonateBlood> donateBlood) {
		this.donateBlood = donateBlood;
	}

}