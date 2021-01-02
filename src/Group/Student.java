package Group;

public class Student implements Human
{

    String name;

    StudentType Pisti = StudentType.MASTERS;

    @Override
    public String getName() {

        return name;
    }

    @Override
    public ScholarType getType() {
        return Pisti;
    }
}
