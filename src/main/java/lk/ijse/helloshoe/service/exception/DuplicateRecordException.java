package lk.ijse.helloshoe.service.exception;

import java.rmi.ServerException;

public class DuplicateRecordException extends ServerException {

    public DuplicateRecordException(String message){super(message);}
    }

