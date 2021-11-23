package by.itacademy.javaenterprise.seledsova.util;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.FlywayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlywayUtil {

    private static final Logger logger = LoggerFactory.getLogger(FlywayUtil.class);
    private static final Flyway flyway = Flyway.configure()
            .dataSource("jdbc:postgresql://localhost:5432/store?useUnicode=true&amp;characterEncoding=UTF-8",
                    "postgres",
                    "postgres")
            .locations("db/migration")
            .load();

    public static void updateMigration() {
        try {
            flyway.migrate();
            logger.info("Migrations was update successful");
        } catch (FlywayException e) {
            logger.error(e.toString(), e);
        }
    }

    public static void cleanMigration() {
        try {
            flyway.clean();
            logger.info("Migration was clean successful");
        } catch (FlywayException e) {
            logger.error(e.toString(), e);
        }
    }
}

