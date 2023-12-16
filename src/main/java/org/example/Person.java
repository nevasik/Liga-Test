package org.example;

public class Person {
    private String FIO;
    private int age;
    private String SNILS;

    public Person() {
    }

    public Person(String FIO, int age, String SNILS) {
        this.FIO = FIO;
        this.age = age;
        this.SNILS = SNILS;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSNILS() {
        return SNILS;
    }

    public void setSNILS(String SNILS) {
        this.SNILS = SNILS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return SNILS != null ? SNILS.equals(person.SNILS) : person.SNILS == null;
    }

    @Override
    public int hashCode() {
        return SNILS != null ? SNILS.hashCode() : 0;
    }
}
