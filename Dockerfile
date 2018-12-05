FROM tomcat:8-jre8

RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh
COPY ./target/futmanager.war /usr/local/tomcat/webapps/futmanager.war

CMD ["catalina.sh", "run"]