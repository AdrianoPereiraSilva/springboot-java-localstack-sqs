#!/usr/bin/env bash

dir=$(pwd)

cd /docker-entrypoint-initaws.d

function newSimpleQueue()
{
  QUEUE=$1
  DLQ=${QUEUE}-dql
  sed -i "s/%DLQ%/${DLQ}/" "POLICY.json"
  awslocal sqs create-queue --queue-name ${DLQ}
  awslocal sqs create-queue --queue-name ${QUEUE} --attributes file://POLICY.json
}

newSimpleQueue localstack-queue

cd $dir

echo "********************* Localstack ready! *********************"