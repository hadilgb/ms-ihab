package com.mysql.demo.controller;

import com.mysql.demo.exception.ResourceNotFoundException;
import com.mysql.demo.model.Clientweb;
import com.mysql.demo.repository.ClientwebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class clientwebcontroller {

        @Autowired
        private ClientwebRepository clientwebRepository;

        @GetMapping("/client_web")
        public List<Clientweb> getAllclient_web() {
            return clientwebRepository.findAll();
        }

        @GetMapping("/client_web/{id}")
        public ResponseEntity<Clientweb> getClientwebById(@PathVariable(value = "id") Long clientwebId)
                throws ResourceNotFoundException {
            Clientweb client = clientwebRepository.findById(clientwebId)
                    .orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientwebId));
            return ResponseEntity.ok().body(client);
        }

        @PostMapping("/client_web")
        public Clientweb createClientweb(@Valid @RequestBody Clientweb clientweb) {
            return clientwebRepository.save(clientweb);
        }

        @PutMapping("/client_web/{id}")
        public ResponseEntity<Clientweb> updateClientweb(@PathVariable(value = "id") Long clientwebId,
                                                       @Valid @RequestBody Clientweb clientwebDetails) throws ResourceNotFoundException {
            Clientweb clientweb = clientwebRepository.findById(clientwebId)
                    .orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientwebId));

            clientweb.setnom(clientwebDetails.getNom());
            clientweb.setprenom(clientwebDetails.getprenom());
            clientweb.settel(clientwebDetails.gettel());
            clientweb.setlogin(clientwebDetails.getlogin());
            clientweb.setmdp(clientwebDetails.getmdp());
            clientweb.setadresse(clientwebDetails.getadresse());
            final Clientweb updatedClientweb = clientwebRepository.save(clientweb);
            return ResponseEntity.ok(updatedClientweb);
        }

        @DeleteMapping("/client_web/{id}")
        public Map<String, Boolean> deleteClientweb(@PathVariable(value = "id") Long clientwebId)
                throws ResourceNotFoundException {
            Clientweb clientweb = clientwebRepository.findById(clientwebId)
                    .orElseThrow(() -> new ResourceNotFoundException("client not found for this id :: " + clientwebId));

            clientwebRepository.delete(clientweb);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }

}
