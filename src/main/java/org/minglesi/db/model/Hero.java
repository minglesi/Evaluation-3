package org.minglesi.db.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.minglesi.validation.HeroNameNotInUse;
import org.minglesi.validation.groups.CreateHero;
import org.minglesi.validation.groups.UpdateHero;

import java.io.Serializable;


@Entity
@Table(name = "HEROES")
public class Hero implements Serializable {
    private Long id;

    @Size(groups = {CreateHero.class, UpdateHero.class}, min=1, max=30, message = "Hero name must be between 1 and 30 characters")
    @HeroNameNotInUse(groups = {CreateHero.class})
    private String name;
    @NotNull(groups = {CreateHero.class, UpdateHero.class}, message = "You must choose a race")
    @Pattern(groups = {CreateHero.class, UpdateHero.class}, regexp = "(^Human$)|(^Orc$)|(^Elf$)|(^Goblin$)", message = "Race must be one of: Human, Orc, Elf or Goblin.")
    private String race;

    @Valid
    private Profession profession;
    private String heroIcon;

    public Hero() {
    }

    public Hero(String name, String race, Profession profession, String heroIcon) {
        this.name = name;
        this.race = race;
        this.profession = profession;
        this.heroIcon = heroIcon;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, unique = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "RACE", nullable = false, length = 10)
    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    @ManyToOne(targetEntity = Profession.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "PROFESSION_ID")
    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Column(name = "ICON", columnDefinition = "TEXT")
    public String getHeroIcon() {
        return heroIcon;
    }

    public void setHeroIcon(String heroIcon) {
        this.heroIcon = heroIcon;
    }


}
