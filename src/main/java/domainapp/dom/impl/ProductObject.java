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

import javax.jdo.annotations.Column;
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

@PersistenceCapable(identityType = IdentityType.DATASTORE , schema = "cetelem_proto", table= "product" )
@javax.jdo.annotations.Unique(name="ProductObject_product_name_UNQ", members = {"product_name"})
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
public class ProductObject implements  Serializable{
//Comparable<ProductObject>,
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	long product_id;
	public long getProduct_id() {return product_id;}
	public void setProduct_id(long product_id) {this.product_id = product_id;}


	@Persistent( mappedBy = "product")
	private Set<VehicleProductObject> vehicleProductObject = new HashSet<>(); 
	
    public Set<VehicleProductObject> getVehicleProductObject() {
		return vehicleProductObject;
	}

	public void setVehicleProductObject(Set<VehicleProductObject> vehicleProductObject) {
		this.vehicleProductObject = vehicleProductObject;
	}
	
	

	public ProductObject(final String product_name) {
        this.product_name = product_name;
    }

    public ProductObject(String product_name, String product_price) {
    	this.product_name = product_name;
    	this.product_price = product_price;
	}

    
    @Property(editing = Editing.DISABLED)
    @Title(prepend = "Object: ")
    private String product_name;
    public String getProduct_name() { return product_name; }
    public void setProduct_name(final String product_name) { this.product_name = product_name; }
    

    @javax.jdo.annotations.Column(allowsNull = "true", length = 40)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    private String product_price;
    public String getProduct_price() { return product_price; }
    public void setProduct_price(final String product_price) { this.product_price = product_price; }

    
    @javax.jdo.annotations.Column(allowsNull = "true", length = 4000)
    @Property(editing = Editing.ENABLED)
    @Title(prepend = "Object: ")
    private String product_description;
    public String getProduct_description() { return product_description; }
    public void setProduct_description(final String product_description) { this.product_description = product_description; }
  
    
    @Action(semantics = SemanticsOf.IDEMPOTENT, command = CommandReification.ENABLED, publishing = Publishing.ENABLED)
    public ProductObject updateProduct_brand_name(
            @Parameter(maxLength = 40)
            //@ParameterLayout(named = "Name")
            final String product_name) {
        setProduct_name(product_name);
        return this;
    }
    public String default0UpdateName() {
        return getProduct_name();
    }


    @Action(semantics = SemanticsOf.NON_IDEMPOTENT_ARE_YOU_SURE)
    public void delete() {
        final String title = titleService.titleOf(this);
        messageService.informUser(String.format("'%s' deleted", title));
        repositoryService.removeAndFlush(this);
    }

    @Override
    public String toString() {
        return getProduct_name();
    }

//    @Override
//    public int compareTo(final ProductObject other) {
//        return ComparisonChain.start()
//                .compare(this.getProduct_name(), other.getProduct_name())
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