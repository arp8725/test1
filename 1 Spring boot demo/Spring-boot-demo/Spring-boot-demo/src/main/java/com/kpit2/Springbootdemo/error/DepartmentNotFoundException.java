package com.kpit2.Springbootdemo.error;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException()
    {
        super();
    }

    public DepartmentNotFoundException(String message)
    {
        super(message);
    }
    public DepartmentNotFoundException(String message,Throwable cause)
    {
        super(message,cause);
    }
    public DepartmentNotFoundException(Throwable cause)
    {
        super(cause);
    }

}
