package OOP_Advanced_Classes.Encapsulation;

public class FootballPlayer {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int shooting;
    private int passing;

    public FootballPlayer(String name,int endurance, int sprint, int dribble,int shooting, int passing){

    }

    public String getName(){return this.name;}

    private void setName(String name){
        if(this.validateName(name)){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name should not be empty or null");
        }


    }

    public int getEndurance(){return this.endurance;}
    private void setEndurance(int endurance){
        if(this.validateStat(endurance)){
            this.endurance = endurance;
        }else{
            throw new IllegalArgumentException("Stat has to be in range 0-100");
        }
    }

    public int getPassing(){return this.passing;}
    private void setPassing(int passing){
        if(this.validateStat(passing)){
            this.passing =passing;
        }else{
            throw new IllegalArgumentException("Stat has to be in range 0-100");
        }
    }

    public int getShooting(){return this.shooting;}
    private void setShooting(int shooting){
        if(this.validateStat(shooting)){
            this.shooting = shooting;
        }else{
            throw new IllegalArgumentException("Stat has to be in range 0-100");
        }
    }

    public int getDribble(){return this.dribble;}
    private void setDribble(int dribble){
        if(this.validateStat(dribble)){
            this.dribble = dribble;
        }else{
            throw new IllegalArgumentException("Stat has to be in range 0-100");
        }
    }

    public int getSprint(){return this.sprint;}
    private void setSprint(int sprint){
        if(this.validateStat(sprint)){
            this.sprint = sprint;
        }else{
            throw new IllegalArgumentException("Stat has to be in range 0-100");
        }
    }


public double overallStatLevel(){
        double overall = (double)(this.getDribble()+this.getEndurance()+this.getPassing()+this.getShooting()
    +this.getSprint());
        return overall;
}


    private boolean validateName(String name){
        if(name!=null && !name.trim().isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    private boolean validateStat(int stat){
        if(stat<0 || stat>100){
            return false;
        }else{
            return true;
        }
    }
}
