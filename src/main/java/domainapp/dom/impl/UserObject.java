/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package domainapp.dom.impl;

import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.VersionStrategy;

import com.google.common.collect.ComparisonChain;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Auditing;
import org.apache.isis.applib.annotation.CommandReification;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

@javax.jdo.annotations.PersistenceCapable(identityType = IdentityType.DATASTORE ,schema = "cetelem_proto", table="user")
@javax.jdo.annotations.DatastoreIdentity(strategy = IdGeneratorStrategy.IDENTITY, column = "user_id")
//@javax.jdo.annotations.Version(strategy= VersionStrategy.DATE_TIME, column ="version")
@javax.jdo.annotations.Unique(name="UserObject_user_username_UNQ", members = {"user_username"})
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
public class UserObject implements Comparable<UserObject> {

    public UserObject(final String user_username) {
        this.user_username = user_username;
    }
    
    public UserObject(final String user_username, final String user_password) {
        this.user_username = user_username;
        this.user_password = user_password;
    }


	@javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @Property(editing = Editing.DISABLED)
    @Title(prepend = "Object: ")
    private String user_username;
    public String getUser_username() { return user_username; }
    public void setUser_username(final String user_username) { this.user_username = user_username; }


    @javax.jdo.annotations.Column(allowsNull = "false", length = 4000)
    @Property(editing = Editing.ENABLED)
    private String user_password;
    public String getUser_password() { return user_password; }
    public void setUser_password(final String user_password) { this.user_password = user_password; }
    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    private String user_lastname;
    public String getUser_lastname() { return user_lastname; }
    public void setUser_lastname(final String user_lastname) { this.user_lastname = user_lastname; }
    
    
    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    private String user_firstname;
    public String getUser_firstname() { return user_firstname; }
    public void setUser_firstname(final String user_firstname) { this.user_firstname = user_firstname; }
    
    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
//    @Join(table = "role")
    private String user_role;
    public String getUser_role() { return user_role; }
    public void setUser_role(final String user_role) { this.user_role = user_role; }

    
    // many to many mapping
//    @Persistent(table="roles_users")
//    @Join(column="user_role")
//    @Element(column="role_id")
//    private Set<RoleObject> roles ;    
//    public Set<RoleObject> getRoles() {return roles;}
//	public void setRoles(Set<RoleObject> roles) {this.roles = roles;}



//    @Action(semantics = SemanticsOf.IDEMPOTENT, command = CommandReification.ENABLED, publishing = Publishing.ENABLED)
//    public UserObject updateUser_username(
//            @Parameter(maxLength = 40)
//           // @ParameterLayout(named = "User_username")
//            final String user_username) {
//        setUser_username(user_username);
//        return this;
//    }
//    public String default0UpdateName() {
//        return getUser_username();
//    }

    
    @Action(semantics = SemanticsOf.IDEMPOTENT, command = CommandReification.ENABLED, publishing = Publishing.ENABLED)
    public UserObject updateUser_username(
            @Parameter(maxLength = 40)
           // @ParameterLayout(named = "User_username")
			final String user_username) {
		setUser_username(user_username);
		return this;
	}


	public String default0UpdateName() {
        return getUser_username();
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE)
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public String toString() {
        return getUser_username();
    }

    @Override
    public int compareTo(final UserObject other) {
        return ComparisonChain.start()
                .compare(this.getUser_username(), other.getUser_username())
                .result();
    }


    @javax.jdo.annotations.NotPersistent
    @javax.inject.Inject
    RepositoryService repositoryService;

    @javax.jdo.annotations.NotPersistent
    @javax.inject.Inject
    TitleService titleService;

    @javax.jdo.annotations.NotPersistent
    @javax.inject.Inject
    MessageService messageService;


}