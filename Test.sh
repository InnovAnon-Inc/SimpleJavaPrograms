#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac Test.java
xargs -L1 -t \
  java  Test < Test.in

