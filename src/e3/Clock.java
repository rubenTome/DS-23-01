package e3;


public class Clock {

    public enum Period {
        AM("AM"),
        PM("PM"),
        NULL("");
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
        if (l != 11 && l != 8)
            throw new IllegalArgumentException();
        if (s.charAt(2) != ':' || s.charAt(5) != ':')
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
            } else
                period = Period.NULL;
        }
    }

    public Clock(int hours, int minutes, int seconds) {
        if (hours >= 24 || minutes >= 60 || seconds >= 60)
            throw new IllegalArgumentException();
        else {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            period = Period.NULL;
        }
    }

    public Clock(int hours, int minutes, int seconds, Period period) {
        if (hours >= 24 || minutes >= 60 || seconds >= 60)
            throw new IllegalArgumentException();
        else {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            this.period = period;
        }
    }

    public int getHours24() {
        if (period.equals(Period.PM))
            return (hours + 12) % 24;
        else
            return hours % 24;
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
        if (period.equals(Period.PM)) ho += 12;
        return String.format(pattern, ho, minutes, seconds);
    }

    public String printHour12() {
        String pattern = "%02d:%02d:%02d %s";
        return String.format(pattern, hours, minutes, seconds, period);
    }

    @Override
    public boolean equals(Object o) {//como comparar clases??
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (!this.getClass().equals(o.getClass()))
            return false;
        else {
            Clock objetoO = (Clock) o;
            int horas = this.hours;
            int horasO = objetoO.hours;
            if (this.getPeriod().getVal().equals(Period.PM.getVal()))
                horas += 12;
            if (objetoO.getPeriod().getVal().equals(Period.PM.getVal()))
                horasO += 12;

            return (this.seconds == objetoO.seconds && this.minutes == objetoO.minutes && horas == horasO);
        }
    }

    @Override
    public int hashCode() {
        int period = 0;
        if (this.getPeriod().getVal().equals(Period.PM.getVal())) period = 12;
        int result = hours + period;
        result = 31 * result + minutes;
        result = 31 * result + seconds;
        return result;
    }
}
