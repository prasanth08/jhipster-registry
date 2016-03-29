# JHipster registry

This is the [JHipster](http://jhipster.github.io/) registry service, based on [Spring Cloud Netflix](http://cloud.spring.io/spring-cloud-netflix/), [Eureka](https://github.com/Netflix/eureka) and [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/).

Full documentation is available on the [JHipster documentation for microservices](http://jhipster.github.io/microservices-architecture).

## Deploy

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

There are a few limitations when deploying to Heroku.

* The registry will only work with [native configuration](http://jhipster.github.io/microservices-architecture/#application-configuration-with-the-jhipster-registry) (and not Git config).
* The registry service cannot be scaled up to multiple dynos to provide redundancy. You must deploy multiple applications (i.e. click the button more than once). This is because Eureka requires distinct URLs to synchronize in-memory state between instances.
* The Registry is not secured by default. You must add it with Spring Security’s basic authentication support.
