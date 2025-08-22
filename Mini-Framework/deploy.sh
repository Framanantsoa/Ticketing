#!/bin/bash

project="Ticketing"
path="/home/fra/ITU/s6/inf313-315/Avion/Mini-Framework"
destination="/opt/tomcat10/webapps"
lib="$path/lib"
resources="$path/src/resources"
package="com/controllers"

webinf="$path/temp/WEB-INF"
classes="$webinf/classes"

mkdir -p $classes/ $webinf/lib

# Compiling *.java 
rm -rf files/
mkdir files/
find src/ -name '*.java' -exec cp {} files/ \;
cd files/
javac -cp "$lib/*" -d "$classes" *.java

# Moving files (img, css, js, jsp, ...)
cp -r $path/bin/META-INF $classes/
cp $path/web.xml $webinf/
cp -r $path/lib/* $webinf/lib/
cd $resources
cp -r * $webinf/../

# Compressing to war file
cd $webinf/../
jar cvf $project.war .

# Copying xxx.war to [webapps] 
cp $project.war $destination
# Give a permission to write 'w' in the folder
chmod -R 755 $destination/$project/upload 

# lauching tomcat
cd $destination/../bin
./startup.sh

# deleting folder temp
cd $path/
rm -r temp/ files/

# finishing
echo "Launch http://localhost:8080/$project now!"

read -n 1 -s -r -p "Press any key to stop Server..."

cd $destination/../bin
./shutdown.sh

cd $destination
rm -r $project*
