#!/bin/sh

grep --color=always --context=3 -r $1 . | less -r
