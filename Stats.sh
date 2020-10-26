#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
javac Stats.java
#xargs -L1 -t \
#  java  Stats < Stats.in

jar cfe Stats.jar Stats *.java *.class
xargs -t \
  java -jar Stats.jar < Stats.in
