package e3;


public class Clock {

    public enum Period {
        AM("AM"),
        PM("PM");

        private final String val;

        Period(String val) {

            this.val = val;
        }

        String getVal() {

            return this.val;
        }
    }

    private final int hours;
    private final int minutes;
    private final int seconds;
    private final Period period;

    public Clock(String s) {
        int ho, min, sec;
        int l = s.length();
        if ((l != 11 && l != 8) || s.charAt(2) != ':' || s.charAt(5) != ':')
            throw new IllegalArgumentException();
        try {
            ho = Integer.parseInt(s.substring(0, 2), 10);
            min = Integer.parseInt(s.substring(3, 5), 10);
            sec = Integer.parseInt(s.substring(6, 8), 10);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
        if (ho >= 24 || min >= 60 || sec >= 60)
            throw new IllegalArgumentException();
        else if (l == 11 && (s.charAt(8) != ' ' || (s.charAt(9) != 'P' && s.charAt(9) != 'A')
                || s.charAt(10) != 'M' || ho > 12)) {
            throw new IllegalArgumentException();
        } else {
            hours = ho;
            minutes = min;
            seconds = sec;
            if (l == 11) {
                if (s.charAt(9) == 'P') period = Period.PM;
                else period = Period.AM;
            } else {
                if (hours > 12) period = Period.PM;
                else period = Period.AM;
            }
        }
    }

    public Clock(int hours, int minutes, int seconds) {
        if (hours >= 24 || minutes >= 60 || seconds >= 60)
            throw new IllegalArgumentException();
        else {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            if (this.hours > 12) period = Period.PM;
            else
                this.period = Period.AM;
        }
    }

    public Clock(int hours, int minutes, int seconds, Period period) {
        if (hours >= 24 || minutes >= 60 || seconds >= 60 || (!period.equals(Period.AM) && !period.equals(Period.PM)))
            throw new IllegalArgumentException();
        else {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.period = period;
        }
    }

    public int getHours24() {
        if (hours <= 12) {
            if (period.equals(Period.PM)) return (hours + 12) % 24;
            else return hours % 12;
        } else
            return hours;
    }

    public int getHours12() {
        if (hours > 12)
            return hours - 12;
        else
            return hours;
    }

    public int getMinutes() {
        return minutes;

    }

    public int getSeconds() {
        return seconds;
    }

    public Period getPeriod() {
        return period;
    }

    public String printHour24() {
        int ho = hours;
        String pattern = "%02d:%02d:%02d";
        if (hours <= 12) {
            if (hours == 12) ho %= 12;
            else if (period.equals(Period.PM)) {
                ho += 12;
                ho %= 24;
            }
        }
        return String.format(pattern, ho, minutes, seconds);
    }

    public String printHour12() {
        int hoursAux;
        if (hours == 12) hoursAux = 12;
        else hoursAux = hours % 12;
        String pattern = "%02d:%02d:%02d %s";
        return String.format(pattern, hoursAux, minutes, seconds, period);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (!this.getClass().equals(o.getClass()))
            return false;
        else {
            Clock objetoO = (Clock) o;
            int horas = hours;
            int horasO = objetoO.hours;
            if (this.hours > 12) horas -= 12;
            if (objetoO.hours > 12) horasO -= 12;
            return (horas == horasO && minutes == objetoO.minutes &&
                    seconds == objetoO.seconds && period.equals(objetoO.period));
        }
    }

    @Override
    public int hashCode() {
        int hoursAux = hours;
        char[] cadenaAux = this.period.getVal().toCharArray();
        if (hours > 12) hoursAux -= 12;
        int result = hoursAux;
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        result = 31 * result + (int) cadenaAux[0];
        result = 31 * result + (int) cadenaAux[1];
        return result;
    }
}
