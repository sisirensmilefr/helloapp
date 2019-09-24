package domainapp.dom.impl;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QRoleObject extends PersistableExpressionImpl<RoleObject> implements PersistableExpression<RoleObject>
{
    public static final QRoleObject jdoCandidate = candidate("this");

    public static QRoleObject candidate(String name)
    {
        return new QRoleObject(null, name, 5);
    }

    public static QRoleObject candidate()
    {
        return jdoCandidate;
    }

    public static QRoleObject parameter(String name)
    {
        return new QRoleObject(RoleObject.class, name, ExpressionType.PARAMETER);
    }

    public static QRoleObject variable(String name)
    {
        return new QRoleObject(RoleObject.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression role_name;
    public final StringExpression role_description;

    public QRoleObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.role_name = new StringExpressionImpl(this, "role_name");
        this.role_description = new StringExpressionImpl(this, "role_description");
    }

    public QRoleObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.role_name = new StringExpressionImpl(this, "role_name");
        this.role_description = new StringExpressionImpl(this, "role_description");
    }
}
