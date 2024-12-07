# Author: Frdy
CONFERENCE_MCS_HOME = conference_microservice
PAPER_MCS_HOME = paper_microservice/Paper
USER_MCS_HOME = user_microservice/user_microservice
REVIEW_MCS_HOME = paperreview_microservice

all: build docker

# Run all microservices
docker:
	docker compose up

# Build all microservices
build: build-paper build-user build-review build-conference

build-paper:
	@echo "Building Paper..."
	cd $(PAPER_MCS_HOME) && ./mvnw package

build-user:
	@echo "Building User..."
	cd $(USER_MCS_HOME) && ./mvnw package

build-review:
	@echo "Building Review..."
	cd $(REVIEW_MCS_HOME) && ./mvnw package

build-conference:
	@echo "Building Conference..."
	cd $(CONFERENCE_MCS_HOME) && ./mvnw package

	