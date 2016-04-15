package br.edu.ufrb.lasis.humv.rest;

import br.edu.ufrb.lasis.humv.utils.HUMVConfig;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

@Component
public class RESTMethods {

    private static Client client = null;
    private static String username = null;
    private static String password = null;

    public static Client getCurrentClient() {
        if (client == null) {
            ClientConfig clientConfig = new DefaultClientConfig();
            clientConfig.getFeatures().put(
                    JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
            client = Client.create(clientConfig);
            client.addFilter(new HTTPBasicAuthFilter(username, password));
        }
        return client;
    }
    
    public static ClientResponse get(String resource) {
        //Example URL: "http://localhost:9090/JerseyJSONExample/rest/jsonServices/send"
        WebResource webResource = getCurrentClient().resource(HUMVConfig.getVetBackendURL() + resource);
        
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        return response;
    }
    
    public static ClientResponse post(String resource, Object object) {
        //Example URL: "http://localhost:9090/JerseyJSONExample/rest/jsonServices/send"
        WebResource webResource = getCurrentClient().resource(HUMVConfig.getVetBackendURL() + resource);
        
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").post(ClientResponse.class, object);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        return response;
    }

    public static ClientResponse put(String resource, Object object) {
        //Example URL: "http://localhost:9090/JerseyJSONExample/rest/jsonServices/send"
        WebResource webResource = getCurrentClient().resource(HUMVConfig.getVetBackendURL() + resource);
        
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").put(ClientResponse.class, object);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        return response;
    }
    
    public static ClientResponse delete(String resource) {
        //Example URL: "http://localhost:9090/JerseyJSONExample/rest/jsonServices/send"
        WebResource webResource = getCurrentClient().resource(HUMVConfig.getVetBackendURL() + resource);
        
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        return response;
    }
    
    public static Object getListFromJSON(ClientResponse response, TypeReference typeReference) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.readValue(response.getEntity(JsonNode.class), typeReference);
        return obj;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        RESTMethods.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        RESTMethods.password = password;
    }

}
