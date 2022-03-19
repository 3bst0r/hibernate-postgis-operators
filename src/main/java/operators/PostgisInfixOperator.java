package operators;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.Type;

import java.util.List;

public class PostgisInfixOperator implements SQLFunction {

    private final String name;
    private final Type registeredType;

    /**
     * Construct a standard SQL function definition with a static return type.
     *
     * @param name The name of the function.
     * @param registeredType The static return type.
     */
    public PostgisInfixOperator(String name, Type registeredType) {
        this.name = name;
        this.registeredType = registeredType;
    }

    /**
     * Function name accessor
     *
     * @return The function name.
     */
    public String getName() {
        return name;
    }

    /**
     * Function static return type accessor.
     *
     * @return The static function return type; or null if return type is
     * not static.
     */
    public Type getType() {
        return registeredType;
    }

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override
    public boolean hasParenthesesIfNoArguments() {
        return true;
    }

    @Override
    public Type getReturnType(Type type, Mapping mapping) throws QueryException {
        return registeredType;
    }

    @Override
    public String render(Type type, List arguments, SessionFactoryImplementor sessionFactoryImplementor) throws QueryException {
        if (arguments.size() != 2) {
            throw new IllegalArgumentException("Postgis infix operator takes exactly two arguments.");
        }
        return arguments.get(0) + getName() + arguments.get(1);
    }
}
