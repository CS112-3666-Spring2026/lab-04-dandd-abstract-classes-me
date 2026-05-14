public class Elf extends GameCharacter {
    public Elf() {
        super();
        setCharacterClass("Elf");
    }

    public Elf(String name, String characterClass, String alignment,
            int gold, int expPoints, int hitPoints, int armorClass,
            Weapon weapon1, Weapon weapon2) {
        super(name, characterClass, alignment, gold, expPoints, hitPoints,
                armorClass, weapon1, weapon2);
    }
    
    public Elf(Elf other) {
        super(other);
    }

    @Override
    public void assist(GameCharacter other) {
        if (other != null) {
            int healingAmount = 10 + getExpPoints() / 10;
            other.setHitPoints(other.getHitPoints() + healingAmount);
        }
    }
    
    @Override
    public boolean attack(GameCharacter other) {
        if (other == null) {
            return false;
        }

        int spellDamage = 15 + getExpPoints() / 5;
        int finalDamage = spellDamage - other.getArmorClass();

        if (finalDamage < 0) {
            finalDamage = 0;
        }

        other.setHitPoints(other.getHitPoints() - finalDamage);

        return finalDamage > 0;
    }
}
