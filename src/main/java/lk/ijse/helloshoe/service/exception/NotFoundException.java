package lk.ijse.helloshoe.service.exception;

import org.hibernate.service.spi.ServiceException;

public class NotFoundException extends ServiceException {
    public NotFoundException(String message){super(message);}
}
