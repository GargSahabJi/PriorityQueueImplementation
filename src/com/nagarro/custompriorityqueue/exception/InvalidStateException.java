/*
* Class name: InvalidStateException
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 16/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Mar/2021
*
* Description: give description of the Exception
*/
package com.nagarro.custompriorityqueue.exception;

public class InvalidStateException {
    private static final String EXCEPTION = "Exception: ";

    public InvalidStateException(String exceptionMessage) {
        System.out.println(EXCEPTION + exceptionMessage);
    }

}
