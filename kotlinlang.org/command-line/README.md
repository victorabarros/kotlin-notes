# compiling from command line

> https://kotlinlang.org/docs/tutorials/command-line.html

## Commands

-|-
-|-
compile|`kotlinc hello.kt -include-runtime -d hello.jar`
execution|`kotlin -classpath hello.jar HelloKt`
script|`kotlinc -script list_folders.kts -- -d <path_to_folder_to_inspect>`
docker|`docker run -it -v $(pwd):$(pwd) -w $(pwd) zenika/kotlin sh -c 'rm -rf hello.jar && kotlinc hello.kt -include-runtime -d hello.jar && kotlin -classpath hello.jar HelloKt'`
docker jdk|`docker run -it -v $(pwd):$(pwd) -w $(pwd) openjdk sh -c 'java -jar hello.jar'`

- more docker examples at https://github.com/Zenika/docker-kotlin/tree/master/examples
