package com.eecs3311.servicebooking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class AvailabilityService {

    // consultantId -> set of available start times
    private final Map<Long, Set<LocalDateTime>> availability = new HashMap<>();

    public AvailabilityService() {
        // demo consultant 1：给一些默认可用时间，方便你演示
        long consultantId = 1L;
        Set<LocalDateTime> slots = new HashSet<>();
        slots.add(LocalDateTime.now().plusHours(2).withSecond(0).withNano(0));
        slots.add(LocalDateTime.now().plusHours(3).withSecond(0).withNano(0));
        slots.add(LocalDateTime.now().plusDays(1).withHour(10).withMinute(0).withSecond(0).withNano(0));
        availability.put(consultantId, slots);
    }

    public List<LocalDateTime> listSlots(long consultantId) {
        Set<LocalDateTime> set = availability.getOrDefault(consultantId, new HashSet<>());
        List<LocalDateTime> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        return list;
    }

    public void addSlot(long consultantId, LocalDateTime startTime) {
        availability.computeIfAbsent(consultantId, k -> new HashSet<>()).add(startTime);
    }

    public void removeSlot(long consultantId, LocalDateTime startTime) {
        availability.getOrDefault(consultantId, new HashSet<>()).remove(startTime);
    }

    // booking request 的时候用：占用一个 slot
    public boolean reserveIfAvailable(long consultantId, LocalDateTime startTime) {
        Set<LocalDateTime> set = availability.getOrDefault(consultantId, new HashSet<>());
        if (!set.contains(startTime)) return false;
        set.remove(startTime);
        return true;
    }
}
