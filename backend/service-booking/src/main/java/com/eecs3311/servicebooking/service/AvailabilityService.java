package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.AvailabilitySlot;
import com.eecs3311.servicebooking.repository.AvailabilitySlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class AvailabilityService {

    private final AvailabilitySlotRepository availabilitySlotRepository;

    public AvailabilityService(AvailabilitySlotRepository availabilitySlotRepository) {
        this.availabilitySlotRepository = availabilitySlotRepository;
    }

    public AvailabilitySlot addSlot(long consultantId, LocalDateTime startTime, LocalDateTime endTime) {
        AvailabilitySlot slot = new AvailabilitySlot(
                null,
                consultantId,
                startTime,
                endTime,
                true
        );
        return availabilitySlotRepository.save(slot);
    }

    public List<AvailabilitySlot> listAll() {
        List<AvailabilitySlot> list = availabilitySlotRepository.findAll();
        list.sort(Comparator.comparing(AvailabilitySlot::getStartTime));
        return list;
    }

    public List<AvailabilitySlot> listByConsultant(long consultantId) {
        List<AvailabilitySlot> list = availabilitySlotRepository.findByConsultantId(consultantId);
        list.sort(Comparator.comparing(AvailabilitySlot::getStartTime));
        return list;
    }

    // 兼容你原来 BookingController 的旧方法名
    public List<AvailabilitySlot> listSlots(long consultantId) {
        return listByConsultant(consultantId);
    }

    // 检查某个 consultant 在某个开始时间是否有可用时段
    public boolean isAvailable(long consultantId, LocalDateTime startTime) {
        return availabilitySlotRepository.findByConsultantId(consultantId).stream()
                .anyMatch(slot ->
                        slot.isAvailable()
                                && !startTime.isBefore(slot.getStartTime())
                                && startTime.isBefore(slot.getEndTime())
                );
    }
}