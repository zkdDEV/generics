package zkd.codes.generic;

import zkd.codes.domain.Vehicle;
import zkd.codes.models.Civic;

import java.util.*;

public class GenericDAO<T extends Vehicle> implements IGenericDAO<T>{

    private Map<Long, T> personalDatabase = new HashMap<>();
    private List<T> database = new ArrayList<>();

    public GenericDAO(T civic, T corolla, T mustang, T aventador){
        addDataToTheBank(civic);
        addDataToTheBank(corolla);
        addDataToTheBank(mustang);
        addDataToTheBank(aventador);
    }

    @Override
    public Boolean add(T object) {
        if(object != null){
            personalDatabase.put(object.getLicensePlateNumber(), object);
            return true;
        }
        return false;
    }

    @Override
    public T search(Long value) {
        T object = personalDatabase.get(value);
        if(object != null){
            return object;
        }
        return null;
    }

    @Override
    public void remove(Long value) {
        personalDatabase.remove(value);
    }

    @Override
    public List<T> seeDataBank() {
        return database;
    }

    @Override
    public void addDataToTheBank(T object) {
        database.add(object);
    }

    @Override
    public T searchDB(Long value) {
        for(T object : database){
            if(object.getLicensePlateNumber().equals(value)){
                return object;
            }
        }
        return null;
    }
}
