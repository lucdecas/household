run:
	@echo -e "\nRunning Application...\n"
	@./gradlew bootRun

debug:
	@echo -e "\nRunning Application in Debug Mode...\n"
	@./gradlew bootRun --debug-jvm