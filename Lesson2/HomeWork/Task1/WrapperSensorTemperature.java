import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WrapperSensorTemperature implements MeteoSensor{

    private static final int SCALE = 6;
    private SensorTemperature sensorTemperature;

    public WrapperSensorTemperature(SensorTemperature sensorTemperature) {
        this.sensorTemperature = sensorTemperature;
    }


    @Override
    public int getId() {
        return sensorTemperature.identifier();
    }

    @Override
    public Float getTemperature() {
        return new BigDecimal(sensorTemperature.temperature())
                .setScale(SCALE, RoundingMode.HALF_UP)
                .floatValue();
    }

    @Override
    public Float getHumidity() {
        return 0.0f;
    }

    @Override
    public Float getPressure() {
        return 0.0f;
    }

    @Override
    public LocalDateTime getDateTime() {
        return LocalDateTime.of(getLocalDate(), getLocalTime());
    }

    private LocalDate getLocalDate(){
        return LocalDate.ofYearDay(sensorTemperature.year(), sensorTemperature.day());
    }

    private LocalTime getLocalTime(){
        return LocalTime.ofSecondOfDay(sensorTemperature.second());
    }
}
