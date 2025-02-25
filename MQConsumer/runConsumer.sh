#!/bin/bash

# Set JBoss Client JAR path (Modify this for your environment)
JBOSS_HOME=/opt/jboss-eap
JBOSS_CLIENT_JAR=$JBOSS_HOME/bin/client/jboss-client.jar

# Set Java classpath
export CLASSPATH=".:$JBOSS_CLIENT_JAR"

# Run Java Consumer
java JBossMQConsumer
