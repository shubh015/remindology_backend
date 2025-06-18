package com.remindology.controller;

import org.springframework.web.bind.annotation.*;

import com.remindology.model.Reminder;
import com.remindology.service.ReminderService;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService){
        this.reminderService = reminderService;
    }

    @GetMapping("/{userId}")
    public List<Reminder> getAll(@PathVariable UUID userId){
      return reminderService.getReminders(userId);
    }

    @PostMapping
    public Reminder create(@RequestBody Reminder reminder){
        return reminderService.addReminder(reminder);
    }

    @PutMapping("/{id}")
    public Reminder update(@PathVariable UUID id, @RequestBody Reminder reminder ) {
        return reminderService.updateReminder(id, reminder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        reminderService.deleteReminder(id);
    }

    @PatchMapping("/{id}/done")
    public Reminder markDone(@PathVariable UUID id){
        return reminderService.markAsDone(id);
    }
}
