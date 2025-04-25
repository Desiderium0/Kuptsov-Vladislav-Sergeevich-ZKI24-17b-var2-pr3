public class Worker extends Person {
  private String position;
  private double salary;

  /**
  * Конструктор по умолчанию.
  */
  public Worker() {
    super();
    this.position = "";
    this.salary = 0.0;
  }

  /**
  * Конструктор с параметрами.
  * @param name имя рабочего
  * @param age возраст рабочего
  * @param position должность
  * @param salary зарплата
  */
  public Worker(String name, int age, String position, double salary) {
    super(name, age);
    this.position = position;
    this.salary = salary;
  }

  /**
  * Получить должность рабочего.
  * @return должность
  */
  public String getPosition() {
    return position;
  }

  /**
  * Установить должность рабочего.
  * @param position новая должность
  */
  public void setPosition(String position) {
    this.position = position;
  }

  /**
  * Получить зарплату рабочего.
  * @return зарплата
  */
  public double getSalary() {
    return salary;
  }

  /**
  * Установить зарплату рабочего.
  * @param salary новая зарплата
  */
  public void setSalary(double salary) {
    this.salary = salary;
  }

  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    if (!(obj instanceof Worker)) return false;
    Worker worker = (Worker) obj;
    return Double.compare(worker.salary, salary) == 0 && position.equals(worker.position);
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + position.hashCode();
    result = 31 * result + Double.hashCode(salary);
    return result;
  }

  public String toString() {
    return "Worker{" +
           "name='" + getName() + "', " +
           "age=" + getAge() + ", " +
           "position='" + position + "', " +
           "salary=" + salary + "}";
  }
}