package domainapp.dom.impl;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QHelloWorldObject2 extends PersistableExpressionImpl<HelloWorldObject> implements PersistableExpression<HelloWorldObject>
{
    public static final QHelloWorldObject2 jdoCandidate = candidate("this");

    public static QHelloWorldObject2 candidate(String name)
    {
        return new QHelloWorldObject2(null, name, 5);
    }

    public static QHelloWorldObject2 candidate()
    {
        return jdoCandidate;
    }

    public static QHelloWorldObject2 parameter(String name)
    {
        return new QHelloWorldObject2(HelloWorldObject.class, name, ExpressionType.PARAMETER);
    }

    public static QHelloWorldObject2 variable(String name)
    {
        return new QHelloWorldObject2(HelloWorldObject.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression name;
    public final StringExpression age;
    public final StringExpression notes;

    public QHelloWorldObject2(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.name = new StringExpressionImpl(this, "name");
        this.age = new StringExpressionImpl(this, "age");
        this.notes = new StringExpressionImpl(this, "notes");
    }

    public QHelloWorldObject2(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.name = new StringExpressionImpl(this, "name");
        this.age = new StringExpressionImpl(this, "age");
        this.notes = new StringExpressionImpl(this, "notes");
    }
}
