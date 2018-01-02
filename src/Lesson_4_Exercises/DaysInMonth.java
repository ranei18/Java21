class DaysInMonth{
    public static void main(String[] args){
        int year = 2016;
        int month = 1;
        if(args.length > 0) month = Integer.parseInt(args[0]);
        if(args.length > 1) year = Integer.parseInt(args[1]);
        
        int days = DayCounter.countDays(month,year);
        
        for(int i = 1;i < days + 1;i++){
            System.out.println("Day " + i);
        }
        
        
    }
}