#!/bin/sh
################################
#   jlGui Un*x Launch Script   #
#                              #
#   http://www.javazoom.net    #
################################
# Modify JAVA_HOME according to your J2SE installation.

JAVA_HOME=/usr/java/jdk1.5.0
JLGUI_HOME=.
# Uncomment line below to enable DEBUG level for traces.
# set LOGIMPL=$JLGUI_HOME/classes

# You should not need to modify the script beyond this point.
# ---------------------------------------------------------------------------------
JAVALAYER=$JLGUI_HOME/lib/jl1.0.jar
MPEGSPI=$JLGUI_HOME/lib/mp3spi1.9.4.jar
VORBISSPI=$JLGUI_HOME/lib/jorbis-0.0.15.jar:$JLGUI_HOME/lib/jogg-0.0.7.jar:$JLGUI_HOME/lib/tritonus_share.jar:$JLGUI_HOME/lib/vorbisspi1.0.2.jar
JSPEEXSPI=$JLGUI_HOME/lib/jspeex0.9.7.jar
JFLACSPI=$JLGUI_HOME/lib/jflac1.2.jar
JMACSPI=$JLGUI_HOME/lib/jmactritonusspi1.74.jar
BASICPLAYER=$JLGUI_HOME/lib/basicplayer3.0.jar
DSP=$JLGUI_HOME/lib/kj_dsp1.1.jar
JLGUI=$JLGUI_HOME/jlgui3.0.jar
LOG=$JLGUI_HOME/lib/commons-logging-api.jar
PATH=$JAVA_HOME/bin:$PATH
CLASSPATH=$LOG:$JLGUI:$VORBISSPI:$JAVALAYER:$MPEGSPI:$JSPEEXSPI:$JFLACSPI:$JMACSPI:$BASICPLAYER:$DSP:$LOGIMPL
JAVA=$JAVA_HOME/bin/java
$JAVA -classpath $CLASSPATH javazoom.jlgui.player.amp.StandalonePlayer
# ---------------------------------------------------------------------------------