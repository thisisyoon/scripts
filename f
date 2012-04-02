#!/bin/sh

# doesn't recurse into dot directories
find . \( \
    \( -type d -name ".?*" -prune \) \
    -or -true \) -name "*$1*"
