Assumptions:
 1. All events/talks are to be scheduled for a single-day conference.But I have designed abstractions
    to support multi-day conference
 2. There are no limits to number of tracks for a day. So the scheduling algorithm with create as many as
    required tracks to schedule all the tasks
 
 
 Instructions to run
 ===================
 1.run mvn clean install
 2.input file is part of source. under src/main/resources.you can copy/place input file here. or
    add the path to classpath
 3.go to /target
 4.run the following command
    java -jar  target/ConferenceTracker-0.0.1-SNAPSHOT-jar-with-dependencies.jar input.txt
    
    input.txt is input text file    