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

import java.io.Serializable;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.Embedded;
import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.apache.isis.applib.annotation.Auditing;

import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;

import org.apache.isis.applib.annotation.Property;

import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

@PersistenceCapable(identityType = IdentityType.DATASTORE,objectIdClass=VehicleProductId.class, schema = "test", table = "vehicle_product")
//@javax.jdo.annotations.DatastoreIdentity(strategy = IdGeneratorStrategy.IDENTITY, column = "vehicle_product_id")
//@javax.jdo.annotations.Version(strategy= VersionStrategy.DATE_TIME, column ="version")

@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout() // causes UI events to be triggered
public class VehicleProductObject implements Serializable  {
//	 Comparable<VehicleProductObject>,
	public VehicleProductObject(final int vehicle_id, final int product_id) {
		this.vehicle_id = vehicle_id;
		this.product_id = product_id;
	}

	@PrimaryKey
	@Column(allowsNull = "false")
	@Property(editing = Editing.DISABLED)
	@Title(prepend = "Object: ")
	@Persistent(defaultFetchGroup = "true", dependent = "false")
	private int vehicle_id;
	public int getVehicle_id() {return vehicle_id;}
	public void setVehicle_id(int vehicle_id) {this.vehicle_id = vehicle_id;}

	@PrimaryKey
	@Column(allowsNull = "true")
	@Property(editing = Editing.ENABLED)
	@Title(prepend = "Object: ")
	@Persistent(defaultFetchGroup = "true", dependent = "false")
	private int product_id;
	public int getProduct_id() {return product_id;}
	public void setProduct_id(int product_id) {this.product_id = product_id;}
	
	
	@Column(allowsNull = "true")
	@Property(editing = Editing.ENABLED)
	@Title(prepend = "Object: ")
	@Persistent
	private int price;
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}

//    @Action(semantics = SemanticsOf.IDEMPOTENT, command = CommandReification.ENABLED, publishing = Publishing.ENABLED)
//    public VehiclesProductsObject updateVehicle_brand_name(
//            @Parameter(maxLength = 40)
//            //@ParameterLayout(named = "Name")
//            final String vehicle_brand_name) {
//        setVehicle_brand_name(vehicle_brand_name);
//        return this;
//    }
//    public String default0UpdateName() {
//        return getVehicle_brand_name();
//    }
//
//
//    @Action(semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE)
//    public void delete() {
//        final String title = titleService.titleOf(this);
//        messageService.informUser(String.format("'%s' deleted", title));
//        repositoryService.removeAndFlush(this);
//    }
//


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

