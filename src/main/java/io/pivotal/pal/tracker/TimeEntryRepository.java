package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry find(long longValue);

    public List<TimeEntry> list();

    public TimeEntry update(long longValue,TimeEntry timeEntry);

    public void delete(long longValue);

}
