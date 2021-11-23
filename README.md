# Home task #16
1. Git repo
2. README file with rules from lecture
3. create new maven/gradle project
4. Create 2 POJO classes with 1 to 1 relation+
5. Create DB schema for classes from #4+
6. Add JPA + hibernate libs to project
7. Configure POJO mapping with JPA annotations
8. Create DAO (use EntityManager) for POJOs with 2 method: save(pojo) and find(id)
9. Tests

# Start script
 docker-compose up -d
# start migrations:
 mvn flyway:migrate

# Completed items
1. Git repo lecture-16
2. README file with rules from lecture DONE
3. create new maven/gradle project DONE
4. Create 2 POJO classes with 1 to 1 relation (People.class and Passport.class)
5. Create DB schema for classes from #4 (classpath:db/migration, classpath: scripts)
6. Add JPA + hibernate libs to project DONE
7. Configure POJO mapping with JPA annotations DONE
8. Create DAO (use EntityManager) for POJOs with 2 method: save(pojo) and find(id) DONE
9. Tests DONE

