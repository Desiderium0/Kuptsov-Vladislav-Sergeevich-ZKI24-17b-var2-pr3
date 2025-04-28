public class Person {
  private String name;
  private int age;

  /**
  * Конструктор по умолчанию.
  */
  public Person() {
    this.name = "";
    this.age = 0;
  }

  /**
  * Конструктор с параметрами.
  * @param name имя персоны
  * @param age возраст персоны
  */
  public Person(String name, int age) {
    this.name = name;
    if (age >= 0) {
      this.age = age;
    }  
    else {
      System.out.println("Возраст не должен быть меньше 0");
    }
  }

  /**
  * Получить имя персоны.
  * @return имя
  */
  public String getName() {
    return name;
  }

  /**
  * Установить имя персоны.
  * @param name новое имя
  */
  public void setName(String name) {
    this.name = name;
  }

  /**
  * Получить возраст персоны.
  * @return возраст
  */
  public int getAge() {
    return age;
  }

  /**
  * Установить возраст персоны.
  * @param age новый возраст
  */
  public void setAge(int age) {
    this.age = age;
  }

  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Person person = (Person) obj;
    return age == person.age && name.equals(person.name);
  }

  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + age;
    return result;
  }

  public String toString() {
    return "Person{name='" + name + "', age=" + age + "}";
  }
}