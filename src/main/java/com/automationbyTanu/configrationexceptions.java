package com.automationbyTanu;

public class configrationexceptions extends RuntimeException {
    String exceptionMessage;
    String cause;




    public configrationexceptions(String message) {
        this.cause =message;
    }




        public String toString( String element) {
            exceptionMessage="Error in configration file.please check the file for any errors /invalid input";
            exceptionMessage+="Exception occured due to:"+cause;
            return exceptionMessage;
        }
    }

