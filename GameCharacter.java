public abstract class GameCharacter {
    private String name;
    private String characterClass;
    private String alignment;
    private int gold;

    int expPoints;
    int hitPoints;
    int armorClass;
    Weapon weapon1;
    Weapon weapon2;

    public GameCharacter() {
        this.name = "Unknown";
        this.characterClass = "Unknown";
        this.alignment = "Unkown";
        this.gold = 0;
        this.expPoints = 0;
        this.hitPoints = 0;
        this.armorClass = 0;
        this.weapon1 = null;
        this.weapon2 = null;
    }

    public GameCharacter(String name, String characterClass, String alignment, int gold, int expPoints, int hitPoints,
            int armorClass, Weapon weapon1, Weapon weapon2) {
        setName(name);
        setCharacterClass(characterClass);
        setAlignment(alignment);
        setGold(gold);
        setExpPoints(expPoints);
        setHitPoints(hitPoints);
        setArmorClass(armorClass);
        setWeapon1(weapon1);
        setWeapon2(weapon2);
    }

    public GameCharacter(GameCharacter other) {
        if (other == null) {
            this.name = "Unknown";
            this.characterClass = "Unknown";
            this.alignment = "Unknown";
            this.gold = 0;
            this.expPoints = 0;
            this.hitPoints = 0;
            this.armorClass = 0;
            this.weapon1 = null;
            this.weapon2 = null;
        } else {
            this.name = other.name;
            this.characterClass = other.characterClass;
            this.alignment = other.alignment;
            this.gold = other.gold;
            this.expPoints = other.expPoints;
            this.hitPoints = other.hitPoints;
            this.armorClass = other.armorClass;

            if (other.weapon1 == null) {
                this.weapon1 = null;
            } else {
                this.weapon1 = new Weapon(other.weapon1);
            }

            if (other.weapon2 == null) {
                this.weapon2 = null;
            } else {
                this.weapon2 = new Weapon(other.weapon2);
            }
        }
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String Class) {
        if (Class != null && Class.length() > 0) {
            this.characterClass = Class;
        } else {
            this.characterClass = "Unknown";
        }
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        if (alignment != null && alignment.length() > 0) {
            this.alignment = alignment;
        } else {
            this.alignment = "Unknown";
        }
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if (gold >= 0) {
            this.gold = gold;
        } else {
            this.gold = 0;
        }
    }

    public int getExpPoints() {
        return expPoints;
    }

    public void setExpPoints(int expPoints) {
        if (expPoints >= 0) {
            this.expPoints = expPoints;
        } else {
            this.expPoints = 0;
        }
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints >= 0) {
            this.hitPoints = hitPoints;
        } else {
            this.hitPoints = 0;
        }
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        if (armorClass >= 0) {
            this.armorClass = armorClass;
        } else {
            this.armorClass = 0;
        }
    }

    public Weapon getWeapon1() {
        if (weapon1 == null) {
            return null;
        }

        return new Weapon(weapon1);
    }

    public void setWeapon1(Weapon weapon1) {
        if (weapon1 == null) {
            this.weapon1 = null;
        } else {
            this.weapon1 = new Weapon(weapon1);
        }
    }

    public Weapon getWeapon2() {
        if (weapon2 == null) {
            return null;
        }

        return new Weapon(weapon2);
    }

    public void setWeapon2(Weapon weapon2) {
        if (weapon2 == null) {
            this.weapon2 = null;
        } else {
            this.weapon2 = new Weapon(weapon2);
        }
    }

    public abstract void assist(GameCharacter other);

    public abstract boolean attack(GameCharacter other);

    @Override
    public String toString() {
        return "GameCharacter{" +
                "name:" + name +
                ", characterClass: " + characterClass +
                ", alignment: " + alignment +
                ", gold:" + gold +
                ", expPoints:" + expPoints +
                ", hitPoints:" + hitPoints +
                ", armorClass:" + armorClass +
                ", weapon1:" + weapon1 +
                ", weapon2:" + weapon2 +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GameCharacter)) {
            return false;
        }

        GameCharacter other = (GameCharacter) obj;

        return this.name.equals(other.name)
                && this.characterClass.equals(other.characterClass)
                && this.alignment.equals(other.alignment)
                && this.gold == other.gold
                && this.expPoints == other.expPoints
                && this.hitPoints == other.hitPoints
                && this.armorClass == other.armorClass
                && weaponsEqual(this.weapon1, other.weapon1)
                && weaponsEqual(this.weapon2, other.weapon2);
    }

    private boolean weaponsEqual(Weapon first, Weapon second) {
        if (first == null && second == null) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        return first.equals(second);
    }
}
