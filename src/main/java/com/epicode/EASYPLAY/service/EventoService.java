package com.epicode.EASYPLAY.service;

import com.epicode.EASYPLAY.model.Evento;
import com.epicode.EASYPLAY.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Iterable<Evento> findAll() {
        return eventoRepository.findAll();
    }
}
