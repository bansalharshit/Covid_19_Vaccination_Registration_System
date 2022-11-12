package com.masai.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrentUserSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique =true)
	private Integer userId;
	
	private String uuid;
	
	private LocalDateTime logInTime;
	
	public CurrentUserSession() {
		super();
	}

	public CurrentUserSession(Integer userId, String uuid, LocalDateTime logInTime) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.logInTime = logInTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return "CurrentUserSession [id=" + id + ", userId=" + userId + ", uuid=" + uuid + ", logInTime=" + logInTime
				+ "]";
	}
	
	
	
	

}
