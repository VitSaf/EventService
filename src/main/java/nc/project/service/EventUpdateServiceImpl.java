package nc.project.service;

import nc.project.model.Event;
import nc.project.model.EventUpdate;
import nc.project.repository.UpdatesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventUpdateServiceImpl implements EventUpdateService {
    private UpdatesRepository updatesRep;
    private EventService eventService;

    @Autowired
    public EventUpdateServiceImpl(UpdatesRepository updatesRep, EventService eventService) {
        this.updatesRep = updatesRep;
        this.eventService = eventService;
    }

    @Override
    public EventUpdate getById(int eventUpdateId) {
        return updatesRep.findById(eventUpdateId);
    }

    @Override
    public ArrayList<EventUpdate> getByEvent(Event event) {
        return updatesRep.findByEvent(event);
    }

    @Override
    public List<EventUpdate> getAll() {
        List<EventUpdate> list = new ArrayList<>();
        for(EventUpdate eu : updatesRep.findAll())
            list.add(eu);
        return list;
    }

    @Override
    public EventUpdate createEventUpdate(EventUpdate newUpdate, Event event) {
        newUpdate.setEvent(event);
        return updatesRep.save(newUpdate);
    }

    @Override
    public EventUpdate updateEventUpdate(int eventUpdateId, EventUpdate updatedEventUpdate) {
        EventUpdate updateFromDD = updatesRep.findById(eventUpdateId);
        BeanUtils.copyProperties(updatedEventUpdate, updateFromDD, "id");
        return updatesRep.save(updateFromDD);
    }

    @Override
    public void deleteEventUpdate(int eventUpdateId) {
        updatesRep.deleteById(eventUpdateId);
    }


}
