Создай иерархию классов на Java 17:
- Абстрактный базовый класс Employee с полями name, department, salary.
- Метод calculateBonus() возвращает 5% от salary.
- Подкласс Manager: бонус 15%, поле subordinatesCount.
- Подкласс Developer: бонус 10% + techBonus, поле programmingLanguage.
- Переопредели toString() в каждом классе.
- Интерфейс Reportable с методом generateReport().
- Реализация Reportable в Manager и Developer.

Employee.java

// Employee.java
public abstract class Employee {
    protected String name;
    protected String department;
    protected double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='%s', department='%s', salary=%.2f, bonus=%.2f}"
                .formatted(name, department, salary, calculateBonus());
    }
}

