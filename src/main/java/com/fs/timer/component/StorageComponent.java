package com.fs.timer.component;

import com.fs.timer.dto.EventDTO;
import com.fs.timer.dto.EventType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

@Component
public class StorageComponent {
    private Map<String, LinkedList<EventDTO>> hm = new HashMap<>();
    Comparator<EventDTO> comparator = (c1, c2) -> c1.getTime() < c2.getTime() ? -1: 1;

    @PostConstruct
    public void postConstructInit(){
        for (EventType event: EventType.values()) {
            hm.put(event.toString(), new LinkedList<>());
        }
    }

    public void addElement(String name, EventDTO d) {
        LinkedList<EventDTO> currentList = hm.get(name);
        if (currentList.size() == 9)
            currentList.poll();
        currentList.add(d);
        hm.put(name, currentList);
    }

    public Map<String, LinkedList<EventDTO>> getAll() {
        Map<String, LinkedList<EventDTO>> map = new HashMap<>();
        this.hm.entrySet()
                .stream()
                .forEach(entry -> {
                    LinkedList<EventDTO> resultList = entry.getValue()
                            .stream()
                            .sorted(comparator)
                            .limit(5)
                            .collect(Collectors.toCollection(LinkedList::new));
                    map.put(entry.getKey(), resultList);
                });
        return map;
    }
}
