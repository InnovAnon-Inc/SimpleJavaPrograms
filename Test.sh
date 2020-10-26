#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac Test.java
#xargs -L1 -t \
#  java  Test < Test.in

jar cfe Test.jar Test *.java *.class
xargs -L1 -t \
  java -jar Test.jar < Test.in
