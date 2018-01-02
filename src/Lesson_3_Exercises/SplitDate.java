package Lesson_3_Exercises;

import java.util.StringTokenizer;

class SplitDate{
    public static void main(String[] args){
        String date = "04/29/2016";
        StringTokenizer split = new StringTokenizer(date,"/");
        System.out.println("Month: " + split.nextToken());
        System.out.println("Date: " + split.nextToken());
        System.out.println("Year: " + split.nextToken());
        
    }
}