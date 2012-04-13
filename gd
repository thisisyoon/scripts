#!/bin/sh

git_dir=`get-git-dir`

if [ -n "$git_dir" ]
then
    cd $git_dir
fi
