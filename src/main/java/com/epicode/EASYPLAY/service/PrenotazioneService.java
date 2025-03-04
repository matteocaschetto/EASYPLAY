package com.epicode.EASYPLAY.service;

import com.epicode.EASYPLAY.model.Prenotazione;
import com.epicode.EASYPLAY.repository.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneRepository.save(prenotazione);
    }

    public Iterable<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }
}
