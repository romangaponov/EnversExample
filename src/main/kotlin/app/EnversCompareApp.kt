package app

import app.feature.BookRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = [BookRepository::class], repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean::class)
@ComponentScan("app.*")
@EntityScan
open class EnversCompareApp

fun main(args: Array<String>) {
    SpringApplication.run(EnversCompareApp::class.java, *args)
}