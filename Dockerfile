FROM maven:3.8.6-jdk-11-slim
RUN apt-get update
RUN apt-get -y install jq
RUN apt-get -y install curl
WORKDIR /perfume/
COPY src /perfume/src/
COPY pom.xml /perfume/
COPY healthcheck.sh /perfume/
ENTRYPOINT ["/bin/sh"]
CMD ["healthcheck.sh"]