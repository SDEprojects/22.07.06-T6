package com.advantage.ghoul;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.*;

class Character {
    private String name;
    private String description;
    private int hp;
    private List<String> inventory = new ArrayList<>();
    private int MAXHP = 30;
    private int xp = 1;
    private int attackPoint;
    private String location;
    private String dialogue;
    private ObjectMapper objectMapper = new ObjectMapper();
    private FileReading file = new FileReading();
    private List<Character> listCharacter;
    private List<String> characterNameList = new ArrayList<>();

    void setHp(int hp) {
        this.hp = hp;
    }

    Character() {
        super();
    }

    Character(String name, String description, int hp, int attackPoint) {
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.attackPoint = attackPoint;
    }

    //business methods
    List<Character> dataReader() {
        try {
            String characterData = file.dataReader("Character.txt");
            listCharacter = objectMapper.readValue(characterData, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCharacter;
    }

    Character getCharacterByName(String name) {
        Character character = null;
        List<Character> characters = dataReader();
        for (Character npc : characters) {
            if (npc.getName().equals(name)) {
                return character = npc;
            }
        }
        return character;
    }

    void attack(Character opponent) {

        int attackPoint = (int) (Math.random() * getAttackPoint());
        if (attackPoint == 0) {
            System.out.println(getName() + " missed. No damage caused.");
        } else {
            System.out.println(getName() + " caused " + attackPoint + " damages");
        }
        monsterHP(attackPoint, opponent);
    }

    void monsterHP(int damage, Character monster) {
        monster.hp -= damage;
        if (monster.hp < 1) {
            System.out.println(this.getName() + " win");

            if (monster.getName().equals("monster")) {
                System.out.println("Monster dropped the library key");
            }
        } else {
            monster.attack(this);
        }
    }

    void addItem(String roomName, String itemName, ItemMenu items, List<Location> rooms) {
        int roomNumber = -1;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getCurrent().equals(roomName) && rooms.get(i).getItem().equals(itemName)) {
                roomNumber = i;
            }
        }
        ItemMenu itemInRoom = items.getItemByName(itemName);
        if (roomNumber == -1) {
            System.out.println("There is no " + itemName + " in this area");
        } else {
            inventory.add(itemName);
            rooms.get(roomNumber).setItem("no item");
            items.setLocation("inventory");
            System.out.println("You get " + itemName + " in your bag!");
        }
    }

    void dropItem(String itemName, Character player, ItemMenu items, List<Location> rooms) {
        for (int i = 0; i < player.getInventory().size(); i++) {
            if (player.getInventory().get(i).equals(itemName)) {
                inventory.remove(itemName);
                System.out.println("You drop " + itemName + " from your bag!");
                items.setLocation(Location.currentRoom);
            } else {
                System.out.println("There is no " + itemName + " to drop from your bag");
            }
        }
    }

    void checkInventory() {
        getInventory();
        if (getInventory().size() > 0) {
            System.out.println("You have following items: " + getInventory() + ".");
        } else {
            System.out.println("You have nothing in your bag");
        }
    }

    void useHealingPotion() {
        int formerHp = getHp();
        if (inventory.contains("healing potion")) {
            if (getHp() == MAXHP) {
                System.out.println("You are healthy. You do not need the healing potion.");
            } else if (getHp() < MAXHP - 5) {
                setHp(getHp() + 5);
                System.out.println("Your Hp went from " + formerHp + " to " + getHp());
            } else {
                setHp(MAXHP);
                System.out.println("You have been restore to complete health.");
            }
        }

        getInventory().remove("healing potion");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHp() {
        return hp;
    }

    public int getXp() {
        return xp;
    }

    public int getAttackPoint() {
        return attackPoint;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getInventory() {
        return inventory;
    }

    public String getDialogue() {
        return dialogue;
    }

    @Override
    public String toString() {
        return "Character: Name= " + getName() + " Description= " + getDescription() + " hp= " + getHp() +
                " hp= " + getXp();
    }

    public static void main(String[] args) {
        Character characters = new Character();

        System.out.println(characters.getCharacterByName("monster"));


        Character player = new Character("Vanessa", "Princess", 100, 10);

        Character enemy = new Character("Ghoul", " Evil", 10, 2);
        player.attack(enemy);


    }
}
