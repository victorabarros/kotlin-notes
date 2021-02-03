clear
docker run -it -v $(pwd):$(pwd) -w $(pwd) zenika/kotlin sh -c 'kotlinc -script script.kts'
