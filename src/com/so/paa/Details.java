package com.so.paa;


import java.time.Duration;
import java.time.LocalDateTime;


public class Details {

    public static Long mov = 0L;
    public static Long comp = 0L;
    public static String time;


    public static void addMoviment() {
        mov++;
    }

    public static void addComparitions() {
        comp++;
    }

    public static void setTime(LocalDateTime startTime) {


        Duration duration = Duration.between(startTime, LocalDateTime.now());

        time = duration.toString()
                .substring(2)
                .replaceAll("(\\d[HMS])(?!$)", "$1 ")
                .toLowerCase();

    }

    public static String formatDuration(Duration duration) {
        long milliseconds = duration.toMillis();
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%02d:%02d::%02d",
                (absSeconds % 3600) / 60,
                absSeconds % 60,
                milliseconds % 1000
        );


        return seconds < 0 ? "-" + positive : positive;
    }

}
