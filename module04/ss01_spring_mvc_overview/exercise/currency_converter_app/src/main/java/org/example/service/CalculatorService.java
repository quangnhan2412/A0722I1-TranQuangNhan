package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double convert(double usd, double rate) {
        return usd * rate;
    }
}
