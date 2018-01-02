class ZipCode {
    private String zipCode = "";
    
    ZipCode(String zip){
       setZip(zip);
    }
    
    public String getZip(){
        return zipCode;
    }
    public void setZip(String zip){
        if(zip.length() != 5){
            zipCode = "";
        }
        else 
            zipCode = zip;
    }
}