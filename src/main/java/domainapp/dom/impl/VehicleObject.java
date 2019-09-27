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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.common.collect.ComparisonChain;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.Auditing;
import org.apache.isis.applib.annotation.CommandReification;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.apache.isis.applib.annotation.Editing;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.Property;
import org.apache.isis.applib.annotation.Publishing;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.annotation.Title;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.omg.CORBA.INTERNAL;

@PersistenceCapable(identityType = IdentityType.DATASTORE, schema = "test", table= "vehicle" )
//@javax.jdo.annotations.Unique(name="VehicleObject_vehicle_brand_name_UNQ", members = {"vehicle_brand_name"})
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered

public class VehicleObject implements Serializable {
// Comparable<VehicleObject>,
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	long vehicle_id;
	

	@Persistent(defaultFetchGroup = "true", mappedBy = "vehicle")
	private Set<VehicleProductObject> vehicleProduct = new HashSet<>(); 
	

    public VehicleObject(final String vehicle_brand_name) {
        this.vehicle_brand_name = vehicle_brand_name;
    }

    public VehicleObject(String vehicle_brand_name, String vehicle_energy, String vehicle_model, String vehicle_price) {
    	this.vehicle_brand_name = vehicle_brand_name;
    	this.vehicle_energy = vehicle_energy;
    	this.vehicle_model = vehicle_model;
    	this.vehicle_price = vehicle_price;
	}
    

	@javax.jdo.annotations.Column(allowsNull = "false", length = 40)
    @Property(editing = Editing.DISABLED)
    @Title(prepend = "Object: ")
	@Persistent
    private String vehicle_brand_name;
    public String getVehicle_brand_name() { return vehicle_brand_name; }
    public void setVehicle_brand_name(final String vehicle_brand_name) { this.vehicle_brand_name = vehicle_brand_name; }
    

    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    @Persistent
    private String vehicle_model;
    public String getVehicle_model() { return vehicle_model; }
    public void setVehicle_model(final String vehicle_model) { this.vehicle_model = vehicle_model; }
    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    @Persistent
    private String vehicle_energy;
    public String getVehicle_energy() { return vehicle_energy; }
    public void setVehicle_energy(final String vehicle_energy) { this.vehicle_energy = vehicle_energy; }
    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    @Persistent
    private String vehicle_price;
    public String getVehicle_price() { return vehicle_price; }
    public void setVehicle_price(final String vehicle_price) { this.vehicle_price = vehicle_price; }

    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    @Persistent
    private String vehicle_description;
    public String getVehicle_description() { return vehicle_description; }
    public void setVehicle_description(final String vehicle_description) { this.vehicle_description = vehicle_description; }
    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    @Persistent
    private String vehicle_picture_url;
    public String getVehicle_picture_url() { return vehicle_picture_url; }
    public void setVehicle_picture_url(final String vehicle_picture_url) { this.vehicle_picture_url = vehicle_picture_url; }
    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    @Persistent
    private String vehicle_transmission;
    public String getVehicle_transmission() { return vehicle_transmission; }
    public void setVehicle_transmission(final String vehicle_transmission) { this.vehicle_transmission = vehicle_transmission; }


    @Action(semantics = SemanticsOf.IDEMPOTENT, command = CommandReification.ENABLED, publishing = Publishing.ENABLED)
    public VehicleObject updateVehicle_brand_name(
            @Parameter(maxLength = 40)
            //@ParameterLayout(named = "Name")
            final String vehicle_brand_name) {
        setVehicle_brand_name(vehicle_brand_name);
        return this;
    }
    public String default0UpdateName() {
        return getVehicle_brand_name();
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE)
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public String toString() {
        return getVehicle_brand_name();
    }

//    @Override
//    public int compareTo(final VehicleObject other) {
//        return ComparisonChain.start()
//                .compare(this.getVehicle_brand_name(), other.getVehicle_brand_name())
//                .result();
//    }


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