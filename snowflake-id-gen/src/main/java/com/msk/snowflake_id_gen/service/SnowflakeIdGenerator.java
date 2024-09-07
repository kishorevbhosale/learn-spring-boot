package com.msk.snowflake_id_gen.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class SnowflakeIdGenerator {

    private final long epoch = 1609459200000L; // Custom epoch (Jan 1, 2021)
    private final long nodeIdBits = 10L;
    private final long sequenceBits = 12L;

    private final long maxNodeId = -1L ^ (-1L << nodeIdBits);
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private final long nodeIdShift = sequenceBits;
    private final long timestampLeftShift = sequenceBits + nodeIdBits;

    private long lastTimestamp = -1L;
    private long sequence = 0L;
    private final long nodeId;

    public SnowflakeIdGenerator() {
        this.nodeId = 1L; // Node ID should be configured for each node
        if (nodeId > maxNodeId) {
            throw new IllegalArgumentException("Node ID exceeds maximum value");
        }
    }

    public synchronized long nextId() {
        long timestamp = currentTimestamp();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id");
        }

        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = waitNextMillis(timestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;

        return ((timestamp - epoch) << timestampLeftShift) | (nodeId << nodeIdShift) | sequence;
    }

    private long waitNextMillis(long lastTimestamp) {
        long timestamp = currentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = currentTimestamp();
        }
        return timestamp;
    }

    private long currentTimestamp() {
        return System.currentTimeMillis();
    }
}