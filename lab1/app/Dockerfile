FROM ubuntu
RUN apt-get update && apt-get install -y git && DEBIAN_FRONTEND="noninteractive" apt-get install -y openjdk-8-jdk && apt-get install -y maven && apt-get install -y postgresql postgresql-contrib
RUN git clone https://github.com/kudryaA/fyre
WORKDIR fyre
RUN mvn package -DskipTests
RUN sed -i 's/peer/trust/g' /etc/postgresql/12/main/pg_hba.conf
RUN service postgresql start && psql -U postgres -c "ALTER USER postgres WITH PASSWORD 'postgress';" && psql -U postgres -f config/initial_script.sql
CMD service postgresql start && java -jar target/fyre-1.0-SNAPSHOT.jar