package ru.itis.dis.s2lab11.services;

import ru.itis.dis.s2lab11.model.Merch;
import java.util.List;

public interface MerchService {
    List<Merch> findByName(String name);
    List<Merch> findByCode(String code);
}
