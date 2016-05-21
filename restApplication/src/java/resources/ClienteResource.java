package resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Cliente;

@Path("/clientes")
public class ClienteResource {
    static List<Cliente> clientes = new ArrayList();
    static{
        clientes.add(new Cliente());
        clientes.get(0).setId(1);
        clientes.get(0).setNome("Zeh");
        
        clientes.add(new Cliente());
        clientes.get(1).setId(2);
        clientes.get(1).setNome("Maria");
        
        clientes.add(new Cliente());
        clientes.get(2).setId(3);
        clientes.get(2).setNome("Jao");
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> todos(){
        return clientes;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Cliente obterPorId(@PathParam("id")int id){
       
        return clientes.stream()
                        .filter(c->c.getId() == id)
                        .findFirst()
                        .get();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserir(Cliente cliente){
        clientes.add(cliente);
        URI uri;
        uri = URI.create("/clientes/1");
        return Response.created(uri)
                        .entity(cliente)
                        .build();
    }
    
}
