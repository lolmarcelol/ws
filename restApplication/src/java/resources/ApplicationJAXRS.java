package resources;
import java.util.*;
import javax.ws.rs.core.Application;    // adicionar biblioteca JAXRS 2.0 

public class ApplicationJAXRS extends Application{
    
    @Override
    public Map<String, Object> getProperties()
    {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.provider.packages","resources"); // configuração do jaxrs 
        return properties;  //criar descritor de implantação (web.xml)
    }
}
