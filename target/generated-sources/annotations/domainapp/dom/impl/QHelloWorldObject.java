package domainapp.dom.impl;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QHelloWorldObject extends PersistableExpressionImpl<HelloWorldObject> implements PersistableExpression<HelloWorldObject>
{
    public static final QHelloWorldObject jdoCandidate = candidate("this");

    public static QHelloWorldObject candidate(String name)
    {
        return new QHelloWorldObject(null, name, 5);
    }

    public static QHelloWorldObject candidate()
    {
        return jdoCandidate;
    }

    public static QHelloWorldObject parameter(String name)
    {
        return new QHelloWorldObject(HelloWorldObject.class, name, ExpressionType.PARAMETER);
    }

    public static QHelloWorldObject variable(String name)
    {
        return new QHelloWorldObject(HelloWorldObject.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression nom;
    public final StringExpression age;
    public final StringExpression notes;

    public QHelloWorldObject(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.nom = new StringExpressionImpl(this, "nom");
        this.age = new StringExpressionImpl(this, "age");
        this.notes = new StringExpressionImpl(this, "notes");
    }

    public QHelloWorldObject(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.nom = new StringExpressionImpl(this, "nom");
        this.age = new StringExpressionImpl(this, "age");
        this.notes = new StringExpressionImpl(this, "notes");
    }
}
