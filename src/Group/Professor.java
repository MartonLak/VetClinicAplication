package Group;

public class Professor implements Human
{
    String name;

    ProfessorType Bojean = ProfessorType.PROFESSOR;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ScholarType getType() {
        return Bojean;
    }
}
