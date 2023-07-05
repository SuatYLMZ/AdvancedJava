package enumType.intro;

public class WeekDayRunner {
    public static void main(String[] args) {
        DaysOfWeek day = DaysOfWeek.THURSDAY;
        System.out.println(day);

        if(day == DaysOfWeek.FRIDAY){
            System.out.println("Yaay, tomorrow is holday...");
        }
        for(DaysOfWeek d: DaysOfWeek.values()){
            System.out.println(d);
        }
    }
}
