291/5000
Application that loads a CSV file with 1 record or 1000 records.
Aspect measures the execution time of the method marked with the @LogExecutionTime annotation:
- save in the database
- reading from the database
- removal from the database

Tested local databases:
- PostgreSQGL (Docker) + JPA (Hibernate)
- MongoDB
- Redis (Docker)
