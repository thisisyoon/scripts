#!/bin/sh

find . -name "*$1" -not \( -type d -name ".?*" -prune \)
