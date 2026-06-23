package zoo.animal;

public sealed interface Cat extends Mammal permits OrangeCat, NotOrangeCat {}
