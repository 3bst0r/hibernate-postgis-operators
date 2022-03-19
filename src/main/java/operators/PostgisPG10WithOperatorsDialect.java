package operators;

import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.spatial.dialect.postgis.PostgisPG10Dialect;

import java.util.Map;

public class PostgisPG10WithOperatorsDialect extends PostgisPG10Dialect {

    public PostgisPG10WithOperatorsDialect() {
        super();
        PostgisInfixOperators postgisInfixOperators = new PostgisInfixOperators();
        for (Map.Entry<String, SQLFunction> entry : postgisInfixOperators) {
            registerFunction(entry.getKey(), entry.getValue());
        }
    }
}
