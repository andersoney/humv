package br.edu.ufrb.lasis.humv.rest;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.HUMVConfigUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.IOException;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RESTMethods {

    private static final String SERVICE_USERNAME = "humv";
    private static final String SERVICE_PASSWORD = "lAs1s_UFRB";

    private static Client createClient(boolean requiresAuth) {
        ClientConfig clientConfig = new DefaultClientConfig();
        //clientConfig.getFeatures().put(
        //        JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        if (requiresAuth) {
            client.addFilter(new HTTPBasicAuthFilter(SERVICE_USERNAME, SERVICE_PASSWORD));
        }
        return client;
    }

    public static ClientResponse get(String resource) throws RESTConnectionException {
        //Exemplo de URL: "http://localhost:9090/JerseyJSONExample/rest/jsonServices/send"
        WebResource webResource = createClient(true).resource(getResourceURL(resource, false));
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus() + "\n\nMensagem: " + response.getEntity(String.class));
        }
        return response;
    }

    public static ClientResponse post(String resource, Object object) throws RESTConnectionException {
        WebResource webResource = createClient(true).resource(getResourceURL(resource, true));

        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, object);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus() + "\n\nMensagem: " + response.getEntity(String.class));
        }
        return response;
    }

    public static ClientResponse put(String resource, Object object) throws RESTConnectionException {
        WebResource webResource = createClient(true).resource(getResourceURL(resource, true));

        ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, object);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus() + "\n\nMensagem: " + response.getEntity(String.class));
        }
        return response;
    }

    public static ClientResponse delete(String resource, String path) throws RESTConnectionException {
        WebResource webResource = createClient(true).resource(getResourceURL(resource, true));

        ClientResponse response = webResource.path("/" + path).delete(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus() + "\n\nMensagem: " + response.getEntity(String.class));
        }
        return response;
    }

    public static ClientResponse userLogin(String resource, String username, String senha) throws Exception {
        WebResource webResource = createClient(false).resource(HUMVConfigUtils.getVetBackendURL() + resource
                + "?username=" + username + "&senha=" + senha
        );

        ClientResponse response = webResource.get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RESTConnectionException(response, "Erro: código HTTP - " + response.getStatus() + "\n\nMensagem: " + response.getEntity(String.class));
        }
        return response;
    }

    public static Object getObjectsFromJSON(ClientResponse response, TypeReference typeReference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Object obj = mapper.readValue(response.getEntityInputStream(), typeReference);
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
