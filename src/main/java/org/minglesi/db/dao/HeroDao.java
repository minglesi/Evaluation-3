package org.minglesi.db.dao;

import org.minglesi.db.model.Hero;

import java.util.List;

public interface HeroDao {
    public void insert(Hero hero);

    public void update(Hero hero);

    public void delete(Integer id);

    public void deleteAll();
    public Hero read(Integer id);
    public List<Hero> readAll();
    public boolean isNameAvailable(String name);
}

