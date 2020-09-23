package OOP_Advanced_Classes.Hero;

public abstract class Hero {
    private String name;
    private String classType;
    private int level;


    public Hero(String name, int level){
    this.setName(name);
    this.setLevel(level);
    }

    private void setName(String name){
        if(name!=null && !name.trim().isEmpty()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Illegal name state.");
        }
    }

    public String getName(){
        return this.name;
    }

    private void setLevel(int level){
        if(level<1 || level>100){
            throw new IllegalArgumentException("Illegal level state.");
        }else{
            this.level = level;
        }
    }

    public int getLevel() {return this.level;}

    private void setClassType(){
        this.classType = this.getClass().getSimpleName();
    }

    @Override
    public String toString(){
        this.setClassType();
        return String.format("Type %s Username: %s Level: %d",this.classType,this.getName(),this.getLevel());
    }


}
