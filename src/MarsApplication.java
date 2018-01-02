class MarsApplication {
    public static void main(String[] args){
        MarsRobot2 spirit = new MarsRobot2();
        spirit.status = "exploring";
        spirit.speed = 2;
        spirit.temperature = -60;
        
        spirit.showAttributes();
        System.out.println("Increasing speed to 3.");
        spirit.speed = 3;
        
        spirit.showAttributes();
        System.out.println("Changing temperature to -90.");
        spirit.temperature = -90;
        
        spirit.showAttributes();
        System.out.println("Checking the temperatures.");
        spirit.checkTemperature();
        spirit.showAttributes();
        
        MarsRobot2 opportunity = new MarsRobot2();
        opportunity.status = "exploring";
        opportunity.speed = 3;
        opportunity.temperature = -30;
        opportunity.showAttributes();
        
    }
}