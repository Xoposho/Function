import java.util.Objects;

public class People {
    private String name;
    private int age;
    private String helloWorld;

    People(String name, int age, String helloWorld){
        this.name = name;
        this.age = age;
        this.helloWorld = helloWorld;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getHelloWorld() {
        return helloWorld;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age && Objects.equals(name, people.name) && Objects.equals(helloWorld, people.helloWorld);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, helloWorld);
    }
}
