#!/bin/sh

# clj - Clojure launcher script

BREAK_CHARS="\(\){}[],^%$#@\"\";:''|\\"

cljjar='lib/clojure.jar'
cljclass='clojure.main'
cljcompletions='.clj_completions'

dir=$0
while [ -h "$dir" ]; do
  ls=`ls -ld "$dir"`
  link=`expr "$ls" : '.*-> \(.*\)$'`

  if expr "$link" : '/.*' > /dev/null; then
    dir="$link"
  else
    dir=`dirname "$dir"`"/$link"
  fi
done

dir=`dirname $dir`
dir=`cd "$dir" > /dev/null && pwd`
#cljjar="$dir/../$cljjar"
cljjar=/Users/edwardruggeri/projects/clojure/clojure.jar
cp="${PWD}"
# XXX add completions back in?
cljcompletions="$dir/../$cljcompletions"

# Add extra jars as specified by `.clojure` file
# Borrowed from <http://github.com/mreid/clojure-framework>
if [ -f .clojure ]; then
  cp=$cp:`cat .clojure`
fi

RLWRAP_ARGS="--remember -c -b $BREAK_CHARS"
JAVA_ARGS="-XX:+TieredCompilation -Xbootclasspath/a:$cljjar -cp $cp"

if [ $# -eq 0 ]; then
  rlwrap $RLWRAP_ARGS java $JAVA_ARGS $cljclass
else
  exec java $JAVA_ARGS $cljclass $*
fi

