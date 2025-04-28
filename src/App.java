import java.util.ArrayList;
import java.util.Scanner;

public class App {
  private static ArrayList<Person> persons = new ArrayList<>();
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    boolean running = true;
        
    while (running) {
      printMenu();
      int choice = getIntInput("Выберите пункт меню: ");
            
      switch (choice) {
        case 1:
          addNewPerson();
          break;
        case 2:
          removePersonByIndex();
          break;
        case 3:
          printAllPersons();
          break;
        case 4:
          compareTwoPersons();
          break;
        case 5:
          running = false;
          System.out.println("Завершение работы приложения.");
          break;
        default:
          System.out.println("Неверный выбор. Попробуйте снова.");
      }
    }
  }

  private static void printMenu() {
    System.out.println("\nМеню:");
    System.out.println("1. Добавить новый элемент");
    System.out.println("2. Удалить элемент по индексу");
    System.out.println("3. Вывод всех элементов в консоль");
    System.out.println("4. Сравнение двух элементов на равенство (по индексам)");
    System.out.println("5. Завершение работы приложения");
  }

  private static int getIntInput(String prompt) {
    System.out.print(prompt);
    while (!scanner.hasNextInt()) {
      System.out.println("Ошибка: введите целое число.");
      scanner.next(); // очистить неправильный ввод
      System.out.print(prompt);
    }
    return scanner.nextInt();
  }

  private static double getDoubleInput(String prompt) {
    System.out.print(prompt);
    while (!scanner.hasNextDouble()) {
      System.out.println("Ошибка: введите число.");
      scanner.next(); // очистить неправильный ввод
      System.out.print(prompt);
    }
    return scanner.nextDouble();
  }

  private static void addNewPerson() {
    System.out.println("\nВыберите тип добавляемого объекта:");
    System.out.println("1. Персона");
    System.out.println("2. Рабочий");
    System.out.println("3. Инженер");
    System.out.println("4. Служащий");
        
    int typeChoice = getIntInput("Ваш выбор: ");
        
    if (typeChoice < 1 || typeChoice > 4) {
      System.out.println("Неверный выбор типа объекта.");
      return;
    }
        
    System.out.print("Введите имя: ");
    scanner.nextLine(); // очистить буфер
    String name = scanner.nextLine();
        
    int age = getIntInput("Введите возраст: ");
    if (age < 0) {
      System.out.println("Возраст не должен быть меньше 0");
      return;
    }
        
    switch (typeChoice) {
      case 1:
        persons.add(new Person(name, age));
        break;
      case 2:
        System.out.print("Введите должность: ");
        String position = scanner.next();
        scanner.nextLine();
        double salary = getDoubleInput("Введите зарплату: ");
        if (salary < 0) {
          System.out.println("Зарплата не должена быть меньше 0");
          return;
        }
        persons.add(new Worker(name, age, position, salary));
        break;
      case 3:
        System.out.print("Введите должность: ");
        position = scanner.next();
        scanner.nextLine();
        salary = getDoubleInput("Введите зарплату: ");
        if (salary <= 0) {
          System.out.println("Зарплата не должена быть меньше 0");
          return;
        }
        System.out.print("Введите специализацию: ");
        String specialization = scanner.next();
        scanner.nextLine();
        int experience = getIntInput("Введите опыт работы (лет): ");
        if (experience < 0){
          System.out.println("Опыт работы не должен быть отрицательным");
          return; 
        }
        persons.add(new Engineer(name, age, position, salary, specialization, experience));
        break;
      case 4:
        System.out.print("Введите отдел: ");
        String department = scanner.next();
        scanner.nextLine();
        System.out.print("Введите роль: ");
        String role = scanner.nextLine();
        int certificate = getIntInput("Введите кол-во сертификатов: ");
        if (certificate < 0){
          System.out.println("Кол-во сертификатов не должен быть отрицательным");
          return; 
        }
        persons.add(new Employee(name, age, department, role, certificate));
        break;
    } 
    System.out.println("Объект успешно добавлен!");
  }

  private static void removePersonByIndex() {
    if (persons.isEmpty()) {
      System.out.println("Коллекция пуста. Нечего удалять.");
      return;
    }
        
    printAllPersons();
    int index = getIntInput("Введите индекс элемента для удаления: ");
        
    if (index >= 0 && index < persons.size()) {
      persons.remove(index);
      System.out.println("Элемент с индексом " + index + " удален.");
    } else {
      System.out.println("Неверный индекс. Элемент не существует.");
    }
  }

  private static void printAllPersons() {
    if (persons.isEmpty()) {
      System.out.println("Коллекция пуста.");
      return;
    }
        
    System.out.println("\nСписок всех элементов:");
    for (int i = 0; i < persons.size(); i++) {
      System.out.println(i + ": " + persons.get(i));
    }
  }

  private static void compareTwoPersons() {
    if (persons.size() < 2) {
      System.out.println("В коллекции должно быть как минимум 2 элемента для сравнения.");
      return;
    }
        
    printAllPersons();
    int index1 = getIntInput("Введите индекс первого элемента: ");
    int index2 = getIntInput("Введите индекс второго элемента: ");
        
    if (index1 >= 0 && index1 < persons.size() && 
        index2 >= 0 && index2 < persons.size()) {
      Person p1 = persons.get(index1);
      Person p2 = persons.get(index2);
            
      if (p1.equals(p2)) {
        System.out.println("Элементы равны.");
      } else {
        System.out.println("Элементы не равны.");
      }
    } else {
      System.out.println("Один или оба индекса неверны.");
    }
  }
}