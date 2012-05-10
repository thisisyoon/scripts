#!/bin/sh

DIR="."
NAME="*"
case $# in
    1)
	NAME=$1
	;;
    2)
	DIR=$1
	NAME=$2
	;;
esac

# doesn't recurse into dot directories
find $DIR \( \
    \( -type d -name ".?*" -prune \) \
    -or -true \) -name "*$NAME*"
