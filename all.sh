#! /usr/bin/env bash
set -euxo pipefail
(( ! $# ))
for k in Util.sh Test{1,2}.sh Stats{,Cacher}{,2}.sh ; do
	PATH=.:$PATH $k || exit 2
done

