package com.epicode.EASYPLAY.controller;


import com.epicode.EASYPLAY.model.Evento;
import com.epicode.EASYPLAY.model.Utente;
import com.epicode.EASYPLAY.service.EventoService;
import com.epicode.EASYPLAY.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UtenteService utenteService;



    @PostMapping
    public ResponseEntity<Evento> creaEvento(@RequestBody Evento evento, @RequestHeader("utenteId") Long utenteId) {
        Optional<Utente> creatore = utenteService.findById(utenteId);
        Evento nuovoEvento = eventoService.creaEvento(evento, creatore.orElse(null));
        return new ResponseEntity<>(nuovoEvento, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaEvento(@PathVariable Long id, @RequestHeader("utenteId") Long utenteId) {
        Optional<Utente> utente = utenteService.findById(id);
        eventoService.eliminaEvento(id, utente.orElse(null));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> modificaEvento(@PathVariable Long id, @RequestBody Evento evento, @RequestHeader("utenteId") Long utenteId) {
        Optional<Utente> utente = utenteService.findById(id);
        Evento eventoModificato = eventoService.modificaEvento(evento, utente.orElse(null));
        return new ResponseEntity<>(eventoModificato, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventi() {
        List<Evento> eventi = eventoService.getAllEventi();
        return new ResponseEntity<>(eventi, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable Long id) {
        Evento evento = eventoService.getEventoById(id);
        if (evento == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
}