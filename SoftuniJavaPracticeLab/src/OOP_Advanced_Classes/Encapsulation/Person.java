package OOP_Advanced_Classes.Encapsulation;

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary){
    this.setName(name);
    this.setAge(age);
    this.setSalary(salary);
    }

    public double getSalary(){return this.salary;}

    private void setSalary(double salary){
        if(salary<460.00){
            throw new IllegalArgumentException("Salary cannot be less than or equal to 0");
        }else{
            this.salary = salary;
        }
    }

    public String getName(){return this.name;}

    private void setName(String name){
        if(name!=null && !name.trim().isEmpty()){
            if(name.length()<3){
                throw new IllegalArgumentException("Invalid name");
            }else{
                this.name = name;
            }

        }else{
            throw new IllegalArgumentException("Name is invalid");
        }
    }

    public int getAge(){return this.age;}

    private void setAge(int age){
        if(age<=0){
            throw new IllegalArgumentException("Age cannot be less than 18");
        }else{
            this.age = age;
        }
    }

    public void increaseSalary(double percentage){
    if(this.getAge()<30){
        this.setSalary(this.getSalary()+(this.getSalary()*(0.01*percentage)));
        this.setSalary(this.getSalary()/200);
    }else{
        this.setSalary(this.getSalary()+(this.getSalary()*(0.01*percentage)));
    }
    }

    @Override
    public String toString() {
       return String.format("Name: %s Age: %d Salary: %f",this.getName(),this.getAge(),this.getSalary());
    }
}
