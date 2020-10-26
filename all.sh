#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
for k in Util.sh Test.sh Stats.sh ; do
	PATH=.:$PATH $k || exit 2
done

