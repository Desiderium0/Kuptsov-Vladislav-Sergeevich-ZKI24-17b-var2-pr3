public class Employee extends Person {
  private String department;
  private String role;
  private int sertificate;

  /**
  * Конструктор по умолчанию.
  */
  public Employee() {
    super();
    this.department = "";
    this.role = "";
    this.sertificate = 0;
  }

  /**
  * Конструктор с параметрами.
  * @param name имя служащего
  * @param age возраст служащего
  * @param department отдел
  * @param role роль
  */
  public Employee(String name, int age, String department, String role, int sertificate) {
    super(name, age);
    this.department = department;
    this.role = role;
    this.sertificate = sertificate;
  }

  /**
  * Получить число сертификатов служащего.
  * @return сертификаты
  */
  public int getSertificate() {
    return sertificate;
  }

  /**
  * Установить сертификат служащего.
  * @param sertificate новый сертификат
  */
  public void setSertificate(int sertificate) {
    if (sertificate > 0) {
      this.sertificate = sertificate;
    } 
    else {
      System.out.println("Сертификатов не может быть меньше 0");
    }
  }

  /**
  * Получить отдел служащего.
  * @return отдел
  */
  public String getDepartment() {
    return department;
  }

  /**
  * Установить отдел служащего.
  * @param department новый отдел
  */
  public void setDepartment(String department) {
    this.department = department;
  }

  /**
  * Получить роль служащего.
  * @return роль
  */
  public String getRole() {
    return role;
  }

  /**
  * Установить роль служащего.
  * @param role новая роль
  */
  public void setRole(String role) {
    this.role = role;
  }

  public boolean equals(Object obj) {
    if (!super.equals(obj)) return false;
    if (!(obj instanceof Employee)) return false;
    Employee employee = (Employee) obj;
    return department.equals(employee.department) && role.equals(employee.role);
  }

  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + department.hashCode();
    result = 31 * result + role.hashCode();
    return result;
  }

  public String toString() {
    return "Employee{" +
           "name='" + getName() + "', " +
           "age=" + getAge() + ", " +
           "department='" + department + "', " +
           "role='" + role + "'}";
    }
}