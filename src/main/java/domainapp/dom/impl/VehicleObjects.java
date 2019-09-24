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

import java.util.List;

import org.datanucleus.query.typesafe.TypesafeQuery;

import org.apache.isis.applib.annotation.Action;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Parameter;
import org.apache.isis.applib.annotation.ParameterLayout;
import org.apache.isis.applib.annotation.RestrictTo;
import org.apache.isis.applib.annotation.SemanticsOf;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.apache.isis.applib.services.repository.RepositoryService;



@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "helloapp.VehicleObjects"
)
public class VehicleObjects {

    @Action(semantics = SemanticsOf.NON_IDEMPOTENT)
    @MemberOrder(sequence = "1")
    public VehicleObject create(
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vehicle_brand_name")
            final String vehicle_brand_name,
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vehicle_energy")
            final String vehicle_energy,
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vehicle_model")
            final String vehicle_model,
            @Parameter(maxLength = 40)
            @ParameterLayout(named = "Vehicle_price")
            final String vehicle_price
            ) {
        return repositoryService.persist(new VehicleObject(vehicle_brand_name,vehicle_brand_name,vehicle_model,vehicle_price));
    }


    @Action(semantics = SemanticsOf.SAFE, restrictTo = RestrictTo.PROTOTYPING)
    @MemberOrder(sequence = "3")
    public List<VehicleObject> listAll() {
        return repositoryService.allInstances(VehicleObject.class);
    }

    @javax.inject.Inject
    RepositoryService repositoryService;

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}
