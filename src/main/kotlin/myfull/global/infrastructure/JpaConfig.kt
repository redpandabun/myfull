package myfull.global.infrastructure

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["myfull"])
@EnableJpaRepositories(basePackages = ["myfull"])
@EnableJpaAuditing(modifyOnCreate = false)
class JpaConfig
