#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac `find . -iname '*.java'`
#xargs -L1 -t \
#  java  Test1 < Test1.in

jar cfe Test1.jar com.innovanon.sjp.letter_grade.Test1 `find . -iname '*.java' -o -iname '*.class'`
xargs -L1 -t \
  java -jar Test1.jar < Test1.in
