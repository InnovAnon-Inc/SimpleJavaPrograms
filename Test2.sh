#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac `find . -iname '*.java'`
#xargs -L1 -t \
#  java  Test2 < Test2.in

jar cfe Test2.jar com.innovanon.sjp.letter_grade.Test2 `find . -iname '*.java' -o -iname '*.class'`
xargs -L1 -t \
  java -jar Test2.jar < Test2.in
