package ait.sad.hw.dmsl;

import java.sql.SQLException;

public class ApplicationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 8538622729264214076L;
    public String exceptionMessage;

    public ApplicationException(SQLException e) {
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(ClassNotFoundException e) {
        // TODO Auto-generated constructor stub
    }

    public ApplicationException(String message) {
        this.exceptionMessage = message;
    }


}
