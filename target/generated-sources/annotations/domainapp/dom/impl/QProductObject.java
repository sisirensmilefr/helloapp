package domainapp.dom.impl;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QProductObject extends PersistableExpressionImpl<ProductObject> implements PersistableExpression<ProductObject>
{
    public static final QProductObject jdoCandidate = candidate("this");

    public static QProductObject candidate(String name)
    {
        return new QProductObject(null, name, 5);
    }

    public static QProductObject candidate()
    {
        return jdoCandidate;
    }

    public static QProductObject parameter(String name)
    {
        return new QProductObject(ProductObject.class, name, ExpressionType.PARAMETER);
    }

    public static QProductObject variable(String name)
    {
        return new QProductObject(ProductObject.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Long> serialVersionUID;
    public final NumericExpression<Long> product_id;
    public final CollectionExpression vehicleProductObject;
    public final StringExpression product_name;
    public final StringExpression product_price;
    public final StringExpression product_description;

    public QProductObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.serialVersionUID = new NumericExpressionImpl<Long>(this, "serialVersionUID");
        this.product_id = new NumericExpressionImpl<Long>(this, "product_id");
        this.vehicleProductObject = new CollectionExpressionImpl(this, "vehicleProductObject");
        this.product_name = new StringExpressionImpl(this, "product_name");
        this.product_price = new StringExpressionImpl(this, "product_price");
        this.product_description = new StringExpressionImpl(this, "product_description");
    }

    public QProductObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.serialVersionUID = new NumericExpressionImpl<Long>(this, "serialVersionUID");
        this.product_id = new NumericExpressionImpl<Long>(this, "product_id");
        this.vehicleProductObject = new CollectionExpressionImpl(this, "vehicleProductObject");
        this.product_name = new StringExpressionImpl(this, "product_name");
        this.product_price = new StringExpressionImpl(this, "product_price");
        this.product_description = new StringExpressionImpl(this, "product_description");
    }
}
