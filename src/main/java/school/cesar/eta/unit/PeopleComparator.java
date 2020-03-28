package school.cesar.eta.unit;

import school.cesar.eta.unit.entity.Person;

import java.time.LocalDate;
import java.time.Month;

public class PeopleComparator {

    public LocalDate getCurrentDate(){
        return LocalDate.now();
    }

    public boolean isTodayPersonsBirthDay(Person person){
        LeapYearCalculator leapYearCalculator = new LeapYearCalculator();
        LocalDate now = getCurrentDate();
        LocalDate birthday = person.getBirthday();

        if (now.getMonth() == birthday.getMonth() && now.getDayOfMonth() == birthday.getDayOfMonth()){
            return true;
        }

        return !leapYearCalculator.isCurrentYearLeapYear()
                && birthday.getDayOfMonth() == 29 && birthday.getMonth() == Month.FEBRUARY;
    }

    public boolean isSameFamily(Person firstPerson, Person secondPerson){
        if(firstPerson.getName().equals(secondPerson.getName())){
            return true;
        }
        if(!firstPerson.getLastName().equals(secondPerson.getLastName())){
            return false;
        }
        if(!firstPerson.getCity().equals(secondPerson.getCity())){
            return false;
        }
        return firstPerson.getState().equals(secondPerson.getState());
    }

    public boolean isSamePerson(Person firstPerson, Person secondPerson) {
        if(firstPerson == secondPerson){
            throw new RuntimeException("Same instance!");
        }
        if(!firstPerson.getName().equals(secondPerson.getName())){
            return false;
        }
        if(!firstPerson.getLastName().equals(secondPerson.getLastName())){
            return false;
        }
        if(!firstPerson.getBirthday().equals(secondPerson.getBirthday())){
            return false;
        }
        if(!firstPerson.getMaritalStatus().equals(secondPerson.getMaritalStatus())){
            return false;
        }
        if(!firstPerson.getCity().equals(secondPerson.getCity())){
            return false;
        }
        return firstPerson.getState().equals(secondPerson.getState());
    }
}
