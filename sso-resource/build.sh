#!/usr/bin/env bash
mvn -Dmaven.test.skip=true -U clean install

docker build -t hub.c.163.com/longfeizheng/sso-resource:1.0 .

#docker push hub.c.163.com/longfeizheng/sso-resource:1.0