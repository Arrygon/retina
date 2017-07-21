#!/bin/bash

#if pipes do not exist, create them

file=./matPIPEin
if [ ! -e "$file" ]; then
    echo "Creating matINpipe!"
    mkfifo matPIPEin
fi

file=./matPIPEout
if [ ! -e "$file" ]; then
    echo "Creating matOUTpipe!"
    mkfifo matPIPEout
fi


#flush the pipes
echo "Flushing the matINpipe" > matPIPEin & cat matPIPEin
echo "Flushing the matOUTpipe" > matPIPEout & cat matPIPEout

file=$HOME/Public/urg_provider
if [ ! -e "$file" ]; then
    echo "Binary is not where it should be! Change the path manually."
    mkfifo matPIPEout
fi

gnome-terminal --command="matlab -nosplash -nodesktop -r read_sensor"

$HOME/Public/urg_provider > matPIPEin < matPIPEout
