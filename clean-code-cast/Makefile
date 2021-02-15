APP_NAME?=ccc-gradle-ktor


init:
	@clear
	@echo "\e[1m\033[33mInitializing project\e[0m"
	@make docker-command STAGE="init" DOCKER_IMAGE="gradle" COMMAND="gradle init"

run:
	@clear
	@echo "\e[1m\033[33mStart running project\e[0m"
	@make docker-command STAGE="run" DOCKER_IMAGE="gradle" COMMAND="gradle run"

debug:
	@clear
	@echo "\e[1m\033[33mDebug mode\e[0m"
	@make docker-command STAGE="debug" DOCKER_IMAGE="gradle" COMMAND="bash"

docker-command: remove-container
	@docker run -it -v $(shell pwd):$(shell pwd) -w $(shell pwd) \
		-p 8080:8092 --name ${APP_NAME}-${STAGE} \
		${DOCKER_IMAGE} sh -c "${COMMAND}"

remove-container-all:
	@make remove-container STAGE="debug"
	@make remove-container STAGE="run"
	@make remove-container STAGE="init"

remove-container:
ifneq ($(shell docker ps -a --filter "name=${APP_NAME}-${STAGE}" -aq 2> /dev/null | wc -l | bc), 0)
	@echo "\e[1m\033[33mRemoving container ${APP_NAME}-${STAGE}\e[0m"
	@docker ps -a --filter "name=${APP_NAME}-${STAGE}" -aq | xargs docker rm -f
endif
