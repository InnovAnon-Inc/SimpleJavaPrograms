#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac -Xlint `find . -iname '*.java'`
#xargs -L1 -t \
#  java  StatsCacher < Stats.in

jar cfe StatsCacher.jar com.innovanon.sjp.numerical_comparison.StatsCacher `find . -iname '*.java' -o -iname '*.class'`
xargs -t \
  java -jar StatsCacher.jar < Stats.in
