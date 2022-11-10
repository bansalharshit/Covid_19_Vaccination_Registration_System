package com.masai.Model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class CurrentUserSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique =true)
	private Integer userId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

	
	public CurrentUserSession(Integer userId, String uuid, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
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


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, localDateTime, userId, uuid);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrentUserSession other = (CurrentUserSession) obj;
		return Objects.equals(id, other.id) && Objects.equals(localDateTime, other.localDateTime)
				&& Objects.equals(userId, other.userId) && Objects.equals(uuid, other.uuid);
	}


	@Override
	public String toString() {
		return "CurrentUserSession [id=" + id + ", userId=" + userId + ", uuid=" + uuid + ", localDateTime="
				+ localDateTime + "]";
	}


	public CurrentUserSession() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
