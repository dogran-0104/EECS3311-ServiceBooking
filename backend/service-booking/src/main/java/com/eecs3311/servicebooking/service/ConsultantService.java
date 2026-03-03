package com.eecs3311.servicebooking.service;

import com.eecs3311.servicebooking.model.Consultant;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ConsultantService {

    private final Map<Long, Consultant> consultants = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public ConsultantService() {
        // 给你一个默认顾问，跟你现在 consultantId=1 的 slots 对上
        Consultant c1 = new Consultant(1L, "Default Consultant", true);
        consultants.put(1L, c1);

        // 再给一个未审批的顾问（方便你演示 UC11）
        Consultant c2 = new Consultant(2L, "New Applicant", false);
        consultants.put(2L, c2);

        // 让 idGen 从 3 开始
        idGen.set(3);
    }

    public List<Consultant> listAll() {
        List<Consultant> list = new ArrayList<>(consultants.values());
        list.sort(Comparator.comparingLong(c -> c.getId() == null ? Long.MAX_VALUE : c.getId()));
        return list;
    }

    public Optional<Consultant> findById(long id) {
        return Optional.ofNullable(consultants.get(id));
    }

    public Consultant register(String name) {
        long id = idGen.getAndIncrement();
        Consultant c = new Consultant(id, name, false); // 新注册默认未审批
        consultants.put(id, c);
        return c;
    }

    // UC11: approve/reject
    public Consultant approve(long id) {
        Consultant c = consultants.get(id);
        if (c == null) throw new NoSuchElementException("Consultant not found: " + id);
        c.setApproved(true);
        return c;
    }

    public Consultant reject(long id) {
        Consultant c = consultants.get(id);
        if (c == null) throw new NoSuchElementException("Consultant not found: " + id);
        c.setApproved(false);
        return c;
    }
}
