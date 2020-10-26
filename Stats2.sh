#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac -Xlint `find . -iname '*.java'`
#xargs -L1 -t \
#  java  Stats2 < Stats.in

jar cfe Stats2.jar com.innovanon.sjp.numerical_comparison.Stats2 `find . -iname '*.java' -o -iname '*.class'`
xargs -t \
  java -jar Stats2.jar < Stats.in
