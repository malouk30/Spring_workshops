package tn.esprit.arctic.first_project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.arctic.first_project.entities.Client;
import tn.esprit.arctic.first_project.services.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {
    IClientService clientService;

    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
        return clientService.findAll();
    }
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        return clientService.findById(clientId);
    }
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c) {
        return clientService.save(c);
    }
    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.delete(clientId);
    }
    @PutMapping("/update-client")
    public Client updateClient(@RequestBody Client c) {
        return clientService.update(c);
    }
}
