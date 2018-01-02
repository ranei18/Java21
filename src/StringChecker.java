class StringChecker{
    public static void main(String[] args){
        String str = "A Lannister always pays his debts.";
        System.out.println("The string is: " + str);
        System.out.println("The length is: " + str.length());
        System.out.println("The substring from 12 to 18: " + str.substring(12,18));
        System.out.println("The index of the first 't': " + str.indexOf('t'));
        System.out.println("The inded of the beginning of the " + "substring \"debts\": " + str.indexOf("debts"));
        System.out.println("The string in uppercase: " + str.toUpperCase());
        
    }
}