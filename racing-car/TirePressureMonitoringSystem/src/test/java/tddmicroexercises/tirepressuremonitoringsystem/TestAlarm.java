package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestAlarm {

    @Mock
    private Sensor sensor;

    AlarmTestable alarm;

    @Before
    public void before(){
        alarm = new AlarmTestable(this.sensor);

    }

    @Test
    public void foo() {
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void test_check_values_inside_threshold() {
        for (double pressure = 17.0; pressure < 21.0; pressure++) {
            when(this.sensor.popNextPressurePsiValue()).thenReturn(pressure);
            alarm.check();
            assertEquals(false, alarm.isAlarmOn());
        }
    }

    @Test
    public void test_check_values_outside_threshold() {

        when(this.sensor.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());

        when(this.sensor.popNextPressurePsiValue()).thenReturn(22.0);
        alarm.check();
        assertEquals(true, alarm.isAlarmOn());

    }

    public class AlarmTestable extends Alarm {

        public AlarmTestable(Sensor newSensor){
            sensor = newSensor;
        }
    }
}
