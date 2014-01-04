# shellattach

shellattach spawns a [Groovy Shell Server](https://github.com/bazhenov/groovy-shell-server)
on an already running JVM. 

## Quick Start

shellattach requires [socat](http://freecode.com/projects/socat) to be able to
run.

shellattach builds with [Gradle](http://www.gradle.org/).

### To Build

```
git clone https://github.com/oxtoacart/shellattach.git
cd shellattach
gradle shadow
```

### To Run

Find your Java process id using `jps` (comes with Java).

```
> jps
55885 lantern-1.1.0-beta2-SNAPSHOT.jar
55918 Jps
68818
```

Start the remote shell on port 6789 for pid 55885

```
> ./shellstart 6789 55885
Loaded shellattach agent, listening for socat connection at port 6789
```

Connect to the remote shell

```
> ./shellconnect 6789
Groovy Shell (2.1.9, JVM: 1.7.0_45)
Type 'help' or '\h' for help.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
groovy:000> 
```

You're now in a Groovy shell that has full access to the JVM running as pid 55885!

To connect again later, there's no need to rerun `shellstart`, just use `shellconnect`.
