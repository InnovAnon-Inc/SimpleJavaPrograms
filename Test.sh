#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac `find . -iname '*.java'`
#xargs -L1 -t \
#  java  Test < Test.in

jar cfe Test.jar com.innovanon.sjp.numerical_comparison.Test `find . -iname '*.java' -o -iname '*.class'`
xargs -L1 -t \
  java -jar Test.jar < Test.in
