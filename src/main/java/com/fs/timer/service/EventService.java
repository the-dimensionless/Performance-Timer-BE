package com.fs.timer.service;

import com.fs.timer.component.StorageComponent;
import com.fs.timer.dto.EventDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Map;

@Service
public class EventService {

    private StorageComponent storageComponent;
    EventService(StorageComponent storageComponent) {
        this.storageComponent = storageComponent;
    }

    public void saveEvent(EventDTO entity) {
        this.storageComponent.addElement(entity.getEventType().toString(), entity);
    }

    public Map<String, LinkedList<EventDTO>>  getEvent() {
        return this.storageComponent.getAll();
    }
}
