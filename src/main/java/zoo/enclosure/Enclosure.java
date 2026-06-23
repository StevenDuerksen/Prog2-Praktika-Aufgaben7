package zoo.enclosure;

import zoo.animal.Animal;

import java.util.HashSet;
import java.util.Set;

public class Enclosure<T extends Animal> {

    private final String name;
    private HashSet<T> animals = new HashSet<>();

    public Enclosure(String name){
        this.name = name;
    }

    public String getEnclosure(){
        return name;
    }

    public boolean add(T animal){
        return animals.add(animal);
    }

    public boolean remove(T animal){
        return animals.remove(animal);
    }

    public HashSet<T> getInhabitants(){
        return animals;
    }

    public void clear(){
        animals.clear();
        IO.println("Enclosure %s was cleared.".formatted(name));
    }

}
