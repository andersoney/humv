package br.edu.ufrb.lasis.humv.rest;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.HUMVConfigUtils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.api.json.JSONConfiguration;
import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

@Component
public class RESTMethods {

    private static final String SERVICE_USERNAME = "humv";
    private static final String SERVICE_PASSWORD = "lAs1s_UFRB";

    private static Client createClient(boolean requiresAuth) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(
                JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        if (requiresAuth) {
            client.addFilter(new HTTPBasicAuthFilter(SERVICE_USERNAME, SERVICE_PASSWORD));
        }
        return client;
    }

    public static ClientResponse get(String resource) throws RESTConnectionException {
        //Exemplo de URL: "http://localhost:9090/JerseyJSONExample/rest/jsonServices/send"
        WebResource webResource = createClient(true).resource(getResourceURL(resource, false));
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus());
        }
        return response;
    }

    public static ClientResponse post(String resource, Object object) throws RESTConnectionException {
        WebResource webResource = createClient(true).resource(getResourceURL(resource, true));

        ClientResponse response = webResource.accept("application/json")
                .type("application/json").post(ClientResponse.class, object);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus());
        }
        return response;
    }

    public static ClientResponse put(String resource, Object object) throws RESTConnectionException {
        WebResource webResource = createClient(true).resource(getResourceURL(resource, true));

        ClientResponse response = webResource.accept("application/json").type("application/json").put(ClientResponse.class, object);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus());
        }
        return response;
    }

    public static ClientResponse delete(String resource, String path) throws RESTConnectionException {
        WebResource webResource = createClient(true).resource(getResourceURL(resource, true));

        ClientResponse response = webResource.path("/" + path).delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus());
        }
        return response;
    }

    public static ClientResponse userLogin(String resource, String username, String senha) throws RESTConnectionException {
        WebResource webResource = createClient(false).resource(HUMVConfigUtils.getVetBackendURL() + resource
                + "?username=" + username + "&senha=" + senha
        );

        ClientResponse response = webResource.get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus());
        }
        return response;
    }

    public static Object getObjectFromJSON(ClientResponse response, TypeReference typeReference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object obj = mapper.readValue(response.getEntity(JsonNode.class), typeReference);
        return obj;
    }

    private static String getResourceURL(String resourceName, boolean temUsername) {
        String URL = HUMVConfigUtils.getVetBackendURL() + resourceName;

        String usernameURL;
        if (resourceName.contains("?")) {
            usernameURL = "&username=";
        } else {
            usernameURL = "?username=";
        }

        if (temUsername) {
            URL = URL + usernameURL + HUMVApp.getNomeUsuario();
        }

        return URL;
    }

}
