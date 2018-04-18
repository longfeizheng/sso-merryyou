#!/usr/bin/env bash
mvn -Dmaven.test.skip=true -U clean install
docker build -t merryyou/sso-client2 .