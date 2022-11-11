package com.masai.Model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
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


}
