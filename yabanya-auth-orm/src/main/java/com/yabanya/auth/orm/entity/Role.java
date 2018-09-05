package com.yabanya.auth.orm.entity;

import com.yabanya.commons.orm.entity.AbstractAuditedEntity;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
@Table(name = "ROLE")
@Access(AccessType.FIELD)
public class Role extends AbstractAuditedEntity {

    private static final long serialVersionUID = 788147891742918640L;

    @Column(nullable = false)
    private String roleName;

    @Column
    private String roleDescription;

    private Role() {}

    public Role(final String roleName, final String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
