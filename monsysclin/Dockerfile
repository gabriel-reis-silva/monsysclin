FROM maven:3.5.0-jdk-8
WORKDIR /apps
COPY . /apps
RUN mvn clean install
# Don't forget to substitute the following with a real mainClass
CMD mvn exec:java -Dexec.mainClass="com.mycompany.Login"