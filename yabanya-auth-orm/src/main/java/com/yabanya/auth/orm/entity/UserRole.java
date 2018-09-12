package com.yabanya.auth.orm.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.yabanya.commons.orm.entity.AbstractAuditedEntity;

@Entity
@Audited
@Access(AccessType.FIELD)
@Table(name = "USER_ROLE")
public class UserRole extends AbstractAuditedEntity {

	private static final long serialVersionUID = -3599233481072479052L;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY, optional = false)
	private User user;
	
	@ManyToOne(targetEntity = Role.class, fetch = FetchType.LAZY, optional = false)
	private Role role;
	
	private UserRole() {}
	
	public UserRole(final User user, final Role role) {
		this.user = user;
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public Role getRole() {
		return role;
	}
}
