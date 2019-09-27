package domainapp.dom.impl;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QVehicleProductObject extends PersistableExpressionImpl<VehicleProductObject> implements PersistableExpression<VehicleProductObject>
{
    public static final QVehicleProductObject jdoCandidate = candidate("this");

    public static QVehicleProductObject candidate(String name)
    {
        return new QVehicleProductObject(null, name, 5);
    }

    public static QVehicleProductObject candidate()
    {
        return jdoCandidate;
    }

    public static QVehicleProductObject parameter(String name)
    {
        return new QVehicleProductObject(VehicleProductObject.class, name, ExpressionType.PARAMETER);
    }

    public static QVehicleProductObject variable(String name)
    {
        return new QVehicleProductObject(VehicleProductObject.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> vehicle_id;
    public final NumericExpression<Integer> product_id;
    public final NumericExpression<Integer> price;

    public QVehicleProductObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.vehicle_id = new NumericExpressionImpl<Integer>(this, "vehicle_id");
        this.product_id = new NumericExpressionImpl<Integer>(this, "product_id");
        this.price = new NumericExpressionImpl<Integer>(this, "price");
    }

    public QVehicleProductObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.vehicle_id = new NumericExpressionImpl<Integer>(this, "vehicle_id");
        this.product_id = new NumericExpressionImpl<Integer>(this, "product_id");
        this.price = new NumericExpressionImpl<Integer>(this, "price");
    }
}
