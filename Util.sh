#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac -Xlint `find . -iname '*.java'`
#xargs -L1 -t \
#  java  Util < Util.in

jar cfe Util.jar com.innovanon.sjp.Util `find . -iname '*.java' -o -iname '*.class'`
xargs -L1 -t \
  java -jar Util.jar < Util.in
