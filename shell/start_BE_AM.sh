#!/bin/sh

COMMON_LIB=$HOME/applications/PaaS-BE-AM
COMMON_CONF=$HOME/applications/PaaS-BE-AM/config
#echo -----------------------------------------COMMON_LIB $COMMON_LIB
export COMMON_LIB

for file in ${COMMON_LIB}/**/*.jar;
do CP=${CP}:$file;
done

CP=${CP}:${COMMON_CONF}
CLASSPATH="${CP}"
export CLASSPATH
#echo $CLASSPATH
export JAVA_OPTIONS=" -Dfile.encoding=UTF-8 -Djava.net.preferIPv4Stack=true -Dsun.net.inetaddr.ttl=10"
export MEM_ARGS="-Xms128m -Xmx512m"

${JAVA_HOME}/bin/java ${MEM_ARGS}  ${JAVA_OPTIONS} com.ai.paas.ipaas.DubboServiceStart $1