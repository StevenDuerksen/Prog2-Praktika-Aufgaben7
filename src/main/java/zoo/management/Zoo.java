package zoo.management;

import zoo.animal.Animal;
import zoo.animal.Mammal;
import zoo.enclosure.Enclosure;

import java.util.*;
import java.util.function.Predicate;

public class Zoo {

    private final HashSet<Enclosure<?>> enclosures = new HashSet<>();
    private final Set<String> enclosureNames = new HashSet<>();

    public boolean addEnclosure(Enclosure<?> enclosure){
        if(!enclosureNames.add(enclosure.getName())){
            return false;
        }

        return enclosures.add(enclosure);
    }

    public List<Enclosure<?>> getEnclosure(){
        return enclosures.stream().toList();
    }

    public Optional<Enclosure<?>> findEnclosureByName(String name){
        return enclosures.stream()
                .filter(enclosure -> name.equals(enclosure.getName()))
                .findFirst();
    }

    public List<Animal> getAllAnimals(){
        return enclosures.stream()
                .flatMap(enclosure -> enclosure.getInhabitants().stream())
                .map(animal -> (Animal) animal)
                .toList();
    }

    public List<Mammal> getAllMammals(){
        return enclosures.stream()
                .flatMap(enclosure -> enclosure.getInhabitants().stream())
                .filter(animal -> animal instanceof Mammal)
                .map(animal -> (Mammal) animal)
                .toList();
    }

    public List<Animal> getAnimalsByPredicate(Predicate<Animal> predicate){
        //TODO
    }
}
