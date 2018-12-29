package invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableTransactionManagement
public class Application{

		public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
		}
}
