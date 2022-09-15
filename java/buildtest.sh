#!/bin/bash

env=$1
tags=$2

echo "[Test Env]" ${env}
if [ -n "$tags" ]
then
echo "[Test Tag]" ${tags}
fi

IFS=',' read -ra TAGS <<< "${tags}"
tag=""
for i in "${TAGS[@]}"; do
	tag=$tag$i","
done

sed -i "s/\(env=\)\(.*\)/\1${env}/g" src/test/resources/environment/env.properties

./mvnw -B clean compile test-compile test -Dgroups=${tag%?}
