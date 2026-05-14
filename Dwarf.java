public class Dwarf extends GameCharacter {

    public Dwarf() {
        super();
        setCharacterClass("Dwarf");
    }

    public Dwarf(String name, String characterClass, String alignment,
                int gold, int expPoints, int hitPoints, int armorClass,
                Weapon weapon1, Weapon weapon2) {
        super(name, characterClass, alignment, gold, expPoints, hitPoints,
            armorClass, weapon1, weapon2);
    }

    public Dwarf(Dwarf other) {
        super(other);
    }

    @Override
    public void assist(GameCharacter other) {
        if (other != null) {
            int armorBoost = 2;
            other.setArmorClass(other.getArmorClass() + armorBoost);
        }
    }

    @Override
    public boolean attack(GameCharacter other) {
        if (other == null) {
            return false;
        }

        int baseDamage = 5;

        Weapon weapon = getWeapon1();

        if (weapon != null) {
            baseDamage = weapon.getDamage() + weapon.getAttackBonus();
        }

        int finalDamage = baseDamage - other.getArmorClass();

        if (finalDamage < 0) {
            finalDamage = 0;
        }

        other.setHitPoints(other.getHitPoints() - finalDamage);

        return finalDamage > 0;
    }
}