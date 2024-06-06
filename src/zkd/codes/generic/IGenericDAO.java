package zkd.codes.generic;

import zkd.codes.domain.Vehicle;

import java.util.Collection;
import java.util.List;

public interface IGenericDAO<T extends Vehicle> {

    public Boolean add(T object);
    public T search(Long value);
    public void remove(Long value);
    public List<T> seeDataBank();
    public void addDataToTheBank(T object);
    public T searchDB(Long value);
}
