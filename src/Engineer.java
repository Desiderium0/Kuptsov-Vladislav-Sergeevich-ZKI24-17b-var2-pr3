public class Engineer extends Worker {
  private String specialization;
  private int experienceYears;

  /**
  * Конструктор по умолчанию.
  */
  public Engineer() {
    super();
    this.specialization = "";
    this.experienceYears = 0;
  }

  /**
  * Конструктор с параметрами.
  * @param name имя инженера
  * @param age возраст инженера
  * @param position должность
  * @param salary зарплата
  * @param specialization специализация
  * @param experienceYears опыт работы (в годах)
  */
  public Engineer(String name, int age, String position, double salary, 
                  String specialization, int experienceYears) {
    super(name, age, position, salary);
    this.specialization = specialization;
    this.experienceYears = experienceYears;
  }

  /**
  * Получить специализацию инженера.
  * @return специализация
  */
  public String getSpecialization() {
    return specialization;
  }

  /**
  * Установить специализацию инженера.
  * @param specialization новая специализация
  */
  public void setSpecialization(String specialization) {
    this.specialization = specialization;
  }

  /**
  * Получить опыт работы инженера.
  * @return опыт работы в годах
  */
  public int getExperienceYears() {
    return experienceYears;
  }

  /**
  * Установить опыт работы инженера.
  * @param experienceYears новый опыт работы в годах
  */
  public void setExperienceYears(int experienceYears) {
    this.experienceYears = experienceYears;
  }

  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    if (!(obj instanceof Engineer)) return false;
    Engineer engineer = (Engineer) obj;
    return experienceYears == engineer.experienceYears && 
            specialization.equals(engineer.specialization);
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + specialization.hashCode();
    result = 31 * result + experienceYears;
    return result;
  }

  public String toString() {
    return "Engineer{" +
           "name='" + getName() + "', " +
           "age=" + getAge() + ", " +
           "position='" + getPosition() + "', " +
           "salary=" + getSalary() + ", " +
           "specialization='" + specialization + "', " +
           "experienceYears=" + experienceYears + "}";
  }
}
