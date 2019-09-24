package domainapp.dom.impl;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QUserObject extends PersistableExpressionImpl<UserObject> implements PersistableExpression<UserObject>
{
    public static final QUserObject jdoCandidate = candidate("this");

    public static QUserObject candidate(String name)
    {
        return new QUserObject(null, name, 5);
    }

    public static QUserObject candidate()
    {
        return jdoCandidate;
    }

    public static QUserObject parameter(String name)
    {
        return new QUserObject(UserObject.class, name, ExpressionType.PARAMETER);
    }

    public static QUserObject variable(String name)
    {
        return new QUserObject(UserObject.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression user_username;
    public final StringExpression user_password;
    public final StringExpression user_lastname;
    public final StringExpression user_firstname;
    public final StringExpression user_role;

    public QUserObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.user_username = new StringExpressionImpl(this, "user_username");
        this.user_password = new StringExpressionImpl(this, "user_password");
        this.user_lastname = new StringExpressionImpl(this, "user_lastname");
        this.user_firstname = new StringExpressionImpl(this, "user_firstname");
        this.user_role = new StringExpressionImpl(this, "user_role");
    }

    public QUserObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.user_username = new StringExpressionImpl(this, "user_username");
        this.user_password = new StringExpressionImpl(this, "user_password");
        this.user_lastname = new StringExpressionImpl(this, "user_lastname");
        this.user_firstname = new StringExpressionImpl(this, "user_firstname");
        this.user_role = new StringExpressionImpl(this, "user_role");
    }
}
