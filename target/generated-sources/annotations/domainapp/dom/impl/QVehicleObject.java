package domainapp.dom.impl;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QVehicleObject extends PersistableExpressionImpl<VehicleObject> implements PersistableExpression<VehicleObject>
{
    public static final QVehicleObject jdoCandidate = candidate("this");

    public static QVehicleObject candidate(String name)
    {
        return new QVehicleObject(null, name, 5);
    }

    public static QVehicleObject candidate()
    {
        return jdoCandidate;
    }

    public static QVehicleObject parameter(String name)
    {
        return new QVehicleObject(VehicleObject.class, name, ExpressionType.PARAMETER);
    }

    public static QVehicleObject variable(String name)
    {
        return new QVehicleObject(VehicleObject.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression vehicle_brand_name;
    public final StringExpression vehicle_model;
    public final StringExpression vehicle_energy;
    public final StringExpression vehicle_price;
    public final StringExpression vehicle_description;
    public final StringExpression vehicle_picture_url;
    public final StringExpression vehicle_transmission;

    public QVehicleObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.vehicle_brand_name = new StringExpressionImpl(this, "vehicle_brand_name");
        this.vehicle_model = new StringExpressionImpl(this, "vehicle_model");
        this.vehicle_energy = new StringExpressionImpl(this, "vehicle_energy");
        this.vehicle_price = new StringExpressionImpl(this, "vehicle_price");
        this.vehicle_description = new StringExpressionImpl(this, "vehicle_description");
        this.vehicle_picture_url = new StringExpressionImpl(this, "vehicle_picture_url");
        this.vehicle_transmission = new StringExpressionImpl(this, "vehicle_transmission");
    }

    public QVehicleObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.vehicle_brand_name = new StringExpressionImpl(this, "vehicle_brand_name");
        this.vehicle_model = new StringExpressionImpl(this, "vehicle_model");
        this.vehicle_energy = new StringExpressionImpl(this, "vehicle_energy");
        this.vehicle_price = new StringExpressionImpl(this, "vehicle_price");
        this.vehicle_description = new StringExpressionImpl(this, "vehicle_description");
        this.vehicle_picture_url = new StringExpressionImpl(this, "vehicle_picture_url");
        this.vehicle_transmission = new StringExpressionImpl(this, "vehicle_transmission");
    }
}
