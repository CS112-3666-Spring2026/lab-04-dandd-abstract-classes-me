public class Weapon {
    private String name;
    private int damage;
    private int range;
    private int attackBonus;

    public Weapon() {
        this.name = "Unknown";
        this.damage = 0;
        this.range = 0;
        this.attackBonus = 0;
    }

    public Weapon(String name, int damage, int range, int attackBonus) {
        setName(name);
        setDamage(damage);
        setRange(range);
        setAttackBonus(attackBonus);
    }

    public Weapon(Weapon other) {
        if (other == null) {
            this.name = "Unknown";
            this.damage = 0;
            this.range = 0;
            this.attackBonus = 0;
        } else {
            this.name = other.name;
            this.damage = other.damage;
            this.range = other.range;
            this.attackBonus = other.attackBonus;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if(name != null && name.length() > 0){
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }
    
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage >= 0) {
            this.damage = damage;
        } else {
            this.damage = 0;
        }
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        if (range >= 0) {
            this.range = range;
        } else {
            this.range = 0;
        }
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        if (attackBonus >= 0) {
            this.attackBonus = attackBonus;
        } else {
            this.attackBonus = 0;
        }
    }

    @Override
    public String toString() {
        return "Weapon{name: " + name + ", damage: " + damage + ", range: " + range + ", attack bonus: " + attackBonus
                + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Weapon)) {
            return false;
        }

        Weapon other = (Weapon) obj;

        return this.name.equals(other.name) && this.damage == other.damage && this.range == other.range &&
        this.attackBonus == other.attackBonus;
    }
}
