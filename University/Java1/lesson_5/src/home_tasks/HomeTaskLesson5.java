package home_tasks;

public class HomeTaskLesson5 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Nai", "Manager",
                "nai@mailbox.com", "892316512", 25000, 27);
        employees[2] = new Employee("Petrovich", "Engineer",
                "petrovich@mailbox.com", "892628312", 45000, 54);
        employees[3] = new Employee("Petrovna", "salary",
                "petrovna@mailbox.com", "892038512", 20000, 41);
        employees[4] = new Employee("Masha", "Engineer",
                "masha@mailbox.com", "8923176219", 30000, 34);


        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].print();
                System.out.println();
            }
        }
    }
}
