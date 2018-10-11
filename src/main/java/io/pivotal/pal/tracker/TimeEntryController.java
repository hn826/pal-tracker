package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;
    private ResponseEntity response;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @ResponseBody
    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntryToCreate);
        response = new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
        return response;

    }

    @ResponseBody
    @GetMapping("/{longValue}")
    public ResponseEntity read(@PathVariable long longValue) {

        TimeEntry readTimeEntry = timeEntryRepository.find(longValue);

        if (readTimeEntry!=null) {
            response = new ResponseEntity(readTimeEntry,HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity list() {
        List<TimeEntry> list = timeEntryRepository.list();
        response = new ResponseEntity(list, HttpStatus.OK);
        return response;
    }

    @ResponseBody
    @PutMapping("/{longValue}")
    public ResponseEntity update(@PathVariable long longValue, @RequestBody TimeEntry timeEntry) {

        TimeEntry updateTimeEntry = timeEntryRepository.update(longValue, timeEntry);

        if (updateTimeEntry!=null) {
            response = new ResponseEntity(updateTimeEntry, HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @DeleteMapping("/{longValue}")
    public ResponseEntity delete(@PathVariable long longValue) {

        timeEntryRepository.delete(longValue);
        response = new ResponseEntity(HttpStatus.NO_CONTENT);
        return response;
    }

}