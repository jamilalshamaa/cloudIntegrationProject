package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		// Start the Spring Boot application and get the context
		ConfigurableApplicationContext springContext = SpringApplication.run(Main.class, args);

		// Load XML configuration files into the Spring Boot application context
		ClassPathXmlApplicationContext integrationContext = new ClassPathXmlApplicationContext(new String[] {
				//"aggregate.xml",        // Existing aggregate configuration
				"javaScriptService.xml",
				//"webServiceCalling.xml",
				//"sqlDatabase.xml"     // The new database configuration
		}, springContext); // Pass the Spring Boot context as the parent

		integrationContext.registerShutdownHook();
		integrationContext.start();

		// Print a message that the context has started
		System.out.println("Integration context has started. The application is now running.");

		// Keep the application context open
		try {
			Thread.sleep(Long.MAX_VALUE); // This will keep the main thread alive indefinitely
		} catch (InterruptedException e) {
			// Handle the interruption here - for example logging the interruption
			System.out.println("Main thread interrupted. The application is shutting down.");
			Thread.currentThread().interrupt(); // Set the interrupt flag
		}
		// Keep the application running to listen to file system events or other triggers
	}
}
