package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private TimeEntry createdTimeEntry;
    private TimeEntry readEntry;
    private TimeEntry updatedEntry;
    private HashMap<Long, TimeEntry> hashMapTimeEntry = new HashMap<Long, TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        TimeEntry createdTimeEntry = new TimeEntry(
                hashMapTimeEntry.size() + 1L,
                timeEntry.getId(),
                timeEntry.getProjectId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        hashMapTimeEntry.put(hashMapTimeEntry.size() + 1L, createdTimeEntry);

        return createdTimeEntry;
    }

    @Override
    public TimeEntry find(long longValue) {

        return hashMapTimeEntry.get(longValue);
    }

    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(hashMapTimeEntry.values());
    }

    @Override
    public TimeEntry update(long longValue, TimeEntry timeEntry) {

        TimeEntry updatedTimeEntry = new TimeEntry(
                longValue,
                timeEntry.getId(),
                timeEntry.getProjectId(),
                timeEntry.getDate(),
                timeEntry.getHours()
        );

        hashMapTimeEntry.put(longValue, updatedTimeEntry);

        return hashMapTimeEntry.get(longValue);
    }

    @Override
    public void delete(long longValue) {

        hashMapTimeEntry.remove(longValue);
    }
}