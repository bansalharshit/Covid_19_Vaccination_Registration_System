package com.masai.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class CurrentAdminSession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private Integer adminId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	
	public CurrentAdminSession(Integer adminId, String uuid, LocalDateTime localDateTime) {
		super();
		this.adminId = adminId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
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


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}


	@Override
	public String toString() {
		return "CurrentAdminSession [id=" + id + ", adminId=" + adminId + ", uuid=" + uuid + ", localDateTime="
				+ localDateTime + "]";
	}


	public CurrentAdminSession(Integer id, Integer adminId, String uuid, LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.adminId = adminId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}


	public CurrentAdminSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
