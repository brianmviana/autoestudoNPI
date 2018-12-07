FROM tomcat:8-jre8

COPY ./target/futmanager.war /usr/local/tomcat/webapps/futmanager.war


CMD ["catalina.sh", "run"]