package com.instrumentshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="authorities_seq_Id")
	@SequenceGenerator(name="authorities_seq_Id", sequenceName="authorities_seq_Id", allocationSize = 1, initialValue = 1)
	@Column
	private int authoritiesId;
	private String username;
	private String authority;	
	
	public int getId() {
		return authoritiesId;
	}
	public void setId(int authoritiesId) {
		this.authoritiesId = authoritiesId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "Authority [id=" + authoritiesId + ", username=" + username + ", authority=" + authority + "]";
	}		
	
}
