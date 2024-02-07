package model;

import java.util.List;

public class Human {

    private String first_name;

    private String last_name;
    private String middle_name;
    private int age;
    private boolean is_married;
    private boolean has_kids;
    private List<String> emails;
    private List<Integer> favorite_numbers;
    private List<Pets> pets;

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public int getAge() {
        return age;
    }

    public boolean isIs_married() {
        return is_married;
    }

    public boolean isHas_kids() {
        return has_kids;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<Integer> getFavorite_numbers() {
        return favorite_numbers;
    }

    public List<Pets> getPets() {
        return pets;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIs_married(boolean is_married) {
        this.is_married = is_married;
    }

    public void setHas_kids(boolean has_kids) {
        this.has_kids = has_kids;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setFavorite_numbers(List<Integer> favorite_numbers) {
        this.favorite_numbers = favorite_numbers;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }
}
