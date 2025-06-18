package com.remindology.service;

import com.remindology.model.Reminder;
import com.remindology.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReminderService {

    private final ReminderRepository reminderRepo;

    public ReminderService(ReminderRepository reminderRepo) {
        this.reminderRepo = reminderRepo;
    }

    public List<Reminder> getReminders(UUID userId) {
        return reminderRepo.findByUserId(userId);
    }

    public Reminder addReminder(Reminder reminder) {
        return reminderRepo.save(reminder);
    }

    public Reminder updateReminder(UUID id, Reminder newReminder) {
        Reminder existing = reminderRepo.findById(id).orElseThrow();
        existing.setTitle(newReminder.getTitle());
        existing.setDescription(newReminder.getDescription());
        existing.setCategory(newReminder.getCategory());
        existing.setRemindAt(newReminder.getRemindAt());
        return reminderRepo.save(existing);
    }

    public void deleteReminder(UUID id) {
        reminderRepo.deleteById(id);
    }

    public Reminder markAsDone(UUID id) {
        Reminder reminder = reminderRepo.findById(id).orElseThrow();
        reminder.setDone(true);
        return reminderRepo.save(reminder);
    }
}
