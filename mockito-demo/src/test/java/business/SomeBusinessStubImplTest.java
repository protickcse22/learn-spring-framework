package business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessStubImplTest {

    @Test
    void findTheGreatestFromAllData_basicScenario() {
        DataService dataServiceStub = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }

    @Test
    void findTheGreatestFromAllData_withOneValue() {
        DataService dataServiceStub = new DataServiceStub2();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25,result);
    }
}
class DataServiceStub implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25,15,5};
    }
}

class DataServiceStub2 implements DataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {25};
    }
}
