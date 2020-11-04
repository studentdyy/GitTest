package learnjava.service;

import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class MailService {
    ZoneId zoneId = ZoneId.systemDefault();

    public void setZoneId(ZoneId zoneId){
        this.zoneId = zoneId;
    }
    public String getTime(){
        return ZonedDateTime.now(this.zoneId).format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }

    public void sendLoginMail(User user){
        System.err.println(String.format("Hi,%s! You are loged in at %s",user.getName(),getTime()));
    }

    public void sendRegistrationMail(User user){
        System.out.println(String.format("Welcome,%s",user.getName()));
    }
}