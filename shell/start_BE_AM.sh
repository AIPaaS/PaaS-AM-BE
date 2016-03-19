
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/config

LIB_DIR=$DEPLOY_DIR/libs
LIB_JARS=$DEPLOY_DIR/libs/*

CP=""
for file in ${LIB_DIR}/*.jar;
do CP=${CP}:$file;
echo $CP
done

echo $CP

nohup ${JAVA_HOME}/bin/java -classpath $CONF_DIR:$CP  com.ai.paas.ipaas.DubboServiceStart $1 &
