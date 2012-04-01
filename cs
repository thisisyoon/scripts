#!/bin/sh

grep --context=3 -r $1 . | less
