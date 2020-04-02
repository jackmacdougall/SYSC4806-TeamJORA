/*package springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springboot.Model.Person;

@Configuration
@ConfigurationProperties(prefix = "PeerToolUser")
public class AppSystemProperties {
    @Value("${currentUser}")
    private Person currentUser;

    public Person getCurrentUser(){
        return currentUser;
    }
    public void setCurrentUser(Person selectedPerson){
        currentUser = selectedPerson;
    }


}
*/