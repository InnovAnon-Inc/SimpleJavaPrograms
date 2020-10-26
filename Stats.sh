#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac `find . -iname '*.java'`
#xargs -L1 -t \
#  java  Stats < Stats.in

jar cfe Stats.jar com.innovanon.sjp.numerical_comparison.Stats `find . -iname '*.java' -o -iname '*.class'`
xargs -t \
  java -jar Stats.jar < Stats.in
