package operators;

import org.hibernate.spatial.dialect.SpatialFunctionsRegistry;
import org.hibernate.type.StandardBasicTypes;

public class PostgisInfixOperators extends SpatialFunctionsRegistry {

    public static final String POSTGIS_OPERATOR = "pgop_";
    public static final String PGOP_2D_DISTANCE = POSTGIS_OPERATOR + "2d_distance";

    public PostgisInfixOperators() {
        put(
                PGOP_2D_DISTANCE,
                new PostgisInfixOperator(
                        "<->",
                        StandardBasicTypes.DOUBLE
                )
        );
    }
}

