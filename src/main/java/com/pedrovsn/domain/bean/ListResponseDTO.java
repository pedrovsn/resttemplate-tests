package com.pedrovsn.domain.bean;

import java.util.List;

public class ListResponseDTO<T extends Object> {

    private long totalRegister;

    private List<T> registers;

    public long getTotalRegister() {
        return totalRegister;
    }

    public void setTotalRegister(long totalRegister) {
        this.totalRegister = totalRegister;
    }

    public List<T> getRegisters() {
        return registers;
    }

    public void setRegisters(List<T> registers) {
        this.registers = registers;
    }
}
