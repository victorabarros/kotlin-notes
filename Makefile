PWD=$(shell pwd)

debug:
	@docker run -it -v ${PWD}:${PWD} -w ${PWD} zenika/kotlin bash
