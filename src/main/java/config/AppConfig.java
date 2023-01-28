package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:application.properties"})
public interface AppConfig extends Config {

    @Key("login")
    String login();

    @Key("password")
    String password();
}
