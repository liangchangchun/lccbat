FROM openjdk:8-jdk

MAINTAINER Lattice Sum #Dockerfile for hmc_es

# change timezone
ENV TZ Asia/Shanghai

VOLUME /tmp
ADD ./target/hmc_es.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
