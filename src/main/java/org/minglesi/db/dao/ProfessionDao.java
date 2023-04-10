package org.minglesi.db.dao;

import org.minglesi.db.model.Profession;

import java.util.List;

public interface ProfessionDao {
    public Profession insert(Profession profession);

    public List<Profession> readAll();

    public boolean isValidProfessionId(Long professionId);
    public boolean isNameAvailable(String name);
}

