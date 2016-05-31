package br.com.casadocodigo.loja.conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("prod")
public class JPAProductionConfiguration {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public Properties propriedadesAdicionais() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;
	}

	@Bean
	public DataSource dataSource() throws URISyntaxException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		URI dbUri = new URI(environment.getProperty("DATABASE_URL"));
		
		String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
		
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}

}
