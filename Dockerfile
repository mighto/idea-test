FROM java

MAINTAINER a b <2029635554@qq.com>

ARG JAR_FILE

ADD target/${JAR_FILE} /app/app.jar

ENTRYPOINT java -jar /app/app.jar