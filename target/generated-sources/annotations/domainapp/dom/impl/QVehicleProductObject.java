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

    public final domainapp.dom.impl.QProductObject product;
    public final domainapp.dom.impl.QVehicleObject vehicle;
    public final NumericExpression<Integer> price;

    public QVehicleProductObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        if (depth > 0)
        {
            this.product = new domainapp.dom.impl.QProductObject(this, "product", depth-1);
        }
        else
        {
            this.product = null;
        }
        if (depth > 0)
        {
            this.vehicle = new domainapp.dom.impl.QVehicleObject(this, "vehicle", depth-1);
        }
        else
        {
            this.vehicle = null;
        }
        this.price = new NumericExpressionImpl<Integer>(this, "price");
    }

    public QVehicleProductObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.product = new domainapp.dom.impl.QProductObject(this, "product", 5);
        this.vehicle = new domainapp.dom.impl.QVehicleObject(this, "vehicle", 5);
        this.price = new NumericExpressionImpl<Integer>(this, "price");
    }
}
