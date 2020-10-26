#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac -Xlint `find . -iname '*.java'`
#xargs -L1 -t \
#  java  StatsCacher2 < Stats.in

jar cfe StatsCacher2.jar com.innovanon.sjp.numerical_comparison.StatsCacher2 `find . -iname '*.java' -o -iname '*.class'`
xargs -t \
  java -jar StatsCacher2.jar < Stats.in
