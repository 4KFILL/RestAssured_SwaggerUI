package runners.user;

import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(
                key = "cucumber.glue",
                value = "stepdefs, hooks"
        ),
        @ConfigurationParameter(
                key = "cucumber.plugin",
                value = "pretty, html:target/cucumber-report.html"
        )
})
public class ApiUser {
}
