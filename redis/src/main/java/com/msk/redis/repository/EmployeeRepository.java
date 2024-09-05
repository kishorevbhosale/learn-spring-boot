package com.msk.redis.repository;


import com.msk.redis.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class EmployeeRepository {

    private static final String HASH_KEY = "Employee";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public EmployeeRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Employee save(Employee employee) {
        redisTemplate.opsForHash().put(HASH_KEY, employee.getId(), employee);
        return employee;
    }

    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(HASH_KEY);
    }

    public Employee findById(String id) {
        return (Employee) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String delete(String id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Employee deleted!";
    }
}