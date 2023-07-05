package practice.multithreads.synchronization;

import java.time.LocalDate;
public class AppointmentCenter {
    private LocalDate day = LocalDate.now();        // 03.24.2023
    public synchronized LocalDate getAppointmentDate(){
        day = day.plusDays(1);
        return day;
    }
}
