package com.fs.timer.dto;

public enum EventType {
    Running {
        @Override
        public String toString() {
            return "RUNNING";
        }
    },
    Cycling {
        @Override
        public String toString() {
            return "CYCLING";
        }
    },
    Swimming {
        @Override
        public String toString() {
            return "SWIMMING";
        }
    }
}
