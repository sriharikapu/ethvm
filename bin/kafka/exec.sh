#!/bin/bash -e

UTIL=${1}
shift

CMD="$@"

docker-compose exec kafka sh -c "kafka-${UTIL} ${@}"

