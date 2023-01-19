package p1;

import java.util.*;

public class Battle {
    public static List<Set<Character>> createRivals(Integer n) {
        List<Set<Character>> rivals = new ArrayList<>(n);
        Set<Character> Heroes = new HashSet<>(n);
        Set<Character> Villains = new HashSet<>(n);
        for (Integer i = 0; i < n; i++) {
            Heroes.add(new Character(CharacterType.Hero, 100));
            Villains.add(new Character(CharacterType.Villain, 100));
        }
        rivals.add(Heroes);
        rivals.add(Villains);
        return rivals;
    }

    public static Character selectRandom(Set<Character> characterSet) {
        Character[] characters = characterSet.toArray(new Character[characterSet.size()]);
        Random random = new Random();
        int randomIndex = random.nextInt(characterSet.size());
        return characters[randomIndex];
    }

    public static EnumMap<CharacterType, Integer> battle(List<Set<Character>> rivals) {
        Set<Character> Heroes = rivals.get(0);
        Set<Character> Villains = rivals.get(1);
        EnumMap<CharacterType, Integer> score = new EnumMap<>(CharacterType.class);
        score.put(CharacterType.Hero, 0);
        score.put(CharacterType.Villain, 0);
        while (Heroes.size() != 0 && Villains.size() != 0) {
            Character villain = selectRandom(Villains);
            Character hero = selectRandom(Heroes);
            while (!hero.isDead() && !villain.isDead()) {
                villain.attacks(hero);
                if (!hero.isDead()) {
                    hero.attacks(villain);
                }
            }
            if (hero.isDead()) {
                Heroes.remove(hero);
                updateScore(CharacterType.Villain, score);
            } else if (villain.isDead()) {
                Villains.remove(villain);
                updateScore(CharacterType.Hero, score);
            }
        }
        return score;
    }

    public static void updateScore(CharacterType type, EnumMap<CharacterType, Integer> score) {
        Integer currentScore = score.get(type);
        score.put(type, currentScore + 1);
    }

    public static void main(String[] args) {
        List<Set<Character>> rivals = createRivals(10);
        EnumMap<CharacterType, Integer> score = battle(rivals);
        if (score.get(CharacterType.Hero) > score.get(CharacterType.Villain)) {
            System.out.println(CharacterType.Hero.toString() + "'s won the battle");
        } else {
            System.out.println(CharacterType.Villain.toString() + "'s won the battle");
        }
        System.out.println("total scores");
        System.out.println("1. " + CharacterType.Hero.toString() + "'s : " + score.get(CharacterType.Hero));
        System.out.println("2. " + CharacterType.Villain.toString() + "'s : " + score.get(CharacterType.Villain));
    }
}
