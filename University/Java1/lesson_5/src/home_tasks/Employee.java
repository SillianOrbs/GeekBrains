package home_tasks;

public class Employee {
    private String name;

    private String position;
    private String email;
    private String phone;
    private int salary;

    private int age;

    public Employee(String name, String position,
                    String email, String phone, int salary, int age) {
        this.name = name;

        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;

        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println("ФИО: '" + name + "'");
        System.out.println("Возраст - " + age);
        System.out.println("Занимаемая должность - '" + position + "'");
        System.out.println("Оклад: " + salary + " руб.");
        System.out.println("Контактная информация:");
        System.out.println("           телефон:  " + phone);
        System.out.println("           email:  " + email);
    }
}
