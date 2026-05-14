public class Main {
    public static void main(String[] args) {
        Weapon bow = new Weapon("Elven Bow", 12, 30, 4);
        Weapon dagger = new Weapon("Dagger", 6, 2, 2);

        Elf elf = new Elf(
                "Legolas", //hopefully no copyright lol
                "Elf",
                "Good",
                150,
                80,
                100,
                8,
                bow,
                dagger
        );

        System.out.println("Elf character created:");
        System.out.println(elf);

        Dwarf dwarf = new Dwarf(
                "Gimli",
                "Dwarf",
                "Neutral",
                90,
                45,
                120,
                12,
                new Weapon("Battle Axe", 18, 1, 3),
                null
        );

        System.out.println();
        System.out.println("Dwarf character created:");
        System.out.println(dwarf);

        System.out.println();
        System.out.println(elf.getName() + " attacks " + dwarf.getName());
        boolean elfHit = elf.attack(dwarf);
        System.out.println("Did " + elf.getName() + " deal damage? " + elfHit);
        System.out.println(dwarf);

        System.out.println();
        System.out.println(elf.getName() + " assists " + dwarf.getName() + " by healing.");
        elf.assist(dwarf);
        System.out.println(dwarf);

        System.out.println();
        System.out.println(dwarf.getName() + " attacks " + elf.getName());
        boolean dwarfHit = dwarf.attack(elf);
        System.out.println("Did " + dwarf.getName() + " deal damage? " + dwarfHit);
        System.out.println(elf);

        System.out.println();
        System.out.println(dwarf.getName() + " assists " + elf.getName() + " by improving armor.");
        dwarf.assist(elf);
        System.out.println(elf);
    }
}