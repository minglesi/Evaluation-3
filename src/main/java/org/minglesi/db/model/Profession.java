package org.minglesi.db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.GenericGenerator;
import org.minglesi.validation.HpManaRelation;
import org.minglesi.validation.ProfessionExists;
import org.minglesi.validation.UniqueProfessionName;
import org.minglesi.validation.groups.CreateHero;
import org.minglesi.validation.groups.CreateProfession;
import org.minglesi.validation.groups.UpdateHero;

import java.io.Serializable;

@Entity
@Table(name = "PROFESSIONS")
@HpManaRelation(groups = {CreateProfession.class})
public class Profession implements Serializable {
    @NotNull(groups = {CreateHero.class, UpdateHero.class}, message = "Invalid Profession")
    @ProfessionExists(groups = {CreateHero.class, UpdateHero.class})
    private Long id;

    @NotBlank(groups = {CreateProfession.class}, message = "You must choose a Profession Name")
    @UniqueProfessionName(groups = {CreateProfession.class})
    private String name;
    @Min(value = 1, message = "Hp must be at least 1", groups = {CreateProfession.class})
    @Max(value = 100, message = "Hp can not be larger than 100", groups = {CreateProfession.class})
    private Integer hp;

    @Min(value = 0, message = "Mana must be at least 0", groups = {CreateProfession.class})
    @Max(value = 99, message = "Mana can not be larger than 99", groups = {CreateProfession.class})
    private Integer mana;

    public Profession() {

    }

    public Profession(String name, Integer hp, Integer mana) {
        this.name = name;
        this.hp = hp;
        this.mana = mana;
    }

    @Id
    @Column(name = "PROFESSION_ID")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, unique = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }
}
