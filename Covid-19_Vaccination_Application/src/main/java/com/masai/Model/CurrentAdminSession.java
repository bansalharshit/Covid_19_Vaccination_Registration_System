package com.masai.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CurrentAdminSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique =true)
	private Integer adminId;
	
	private String uuid;
	
	private LocalDateTime logInTime;
	
	public CurrentAdminSession() {
		super();
	}

	public CurrentAdminSession(Integer adminId, String uuid, LocalDateTime logInTime) {
		super();
		this.adminId = adminId;
		this.uuid = uuid;
		this.logInTime = logInTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getLogInTime() {
		return logInTime;
	}

	public void setLogInTime(LocalDateTime logInTime) {
		this.logInTime = logInTime;
	}

	@Override
	public String toString() {
		return "CurrentAdminSession [id=" + id + ", adminId=" + adminId + ", uuid=" + uuid + ", logInTime=" + logInTime
				+ "]";
	}
	
	


}
