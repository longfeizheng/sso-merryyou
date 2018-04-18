#!/bin/sh
mvn package -Dmaven.test.skip=true
docker build -t merryyou/sso-client1 .