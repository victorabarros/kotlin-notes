PWD=$(shell pwd)

init:
	@echo "\e[1m\033[33mInitializing project\e[0m"
	@make docker-command DOCKER_IMAGE="gradle" COMMAND="gradle init"

debug:
	@echo "\e[1m\033[33mDebug mode\e[0m"
	@make docker-command DOCKER_IMAGE="gradle" COMMAND="bash"

docker-command:
	@docker run -it -v $(shell pwd):${APP_DIR} -w ${APP_DIR} \
		${DOCKER_IMAGE} bash -c "${COMMAND}"
