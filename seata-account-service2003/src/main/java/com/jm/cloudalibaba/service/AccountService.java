package com.jm.cloudalibaba.service;

import java.math.BigDecimal;

public interface AccountService {
    void decrease(Long id, BigDecimal money);
}
