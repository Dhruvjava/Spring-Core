import org.hibernate.dialect.PostgreSQLDialect;
import org.hibernate.id.IdentityGenerator;

@SuppressWarnings("deprecation")
public class RedshiftDialect extends PostgreSQLDialect {

    @Override
    public String getIdentitySelectString(String table, String column, int type) {
        return "SELECT MAX("+column+") from "+table;
    }

    @Override
    public String getIdentitySelectString() {
        return "SELECT 1 FROM PG_TEST";
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class getNativeIdentifierGeneratorClass() {
        return IdentityGenerator.class;
    }
}
