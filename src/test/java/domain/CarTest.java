package domain;

import domain.car.Sonata;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @DisplayName("소나타 자동차 생성_여행 거리")
    void sonata_create(){
        Sonata sonata = new Sonata(150);
        assertThat(sonata.getTripDistance()).isEqualTo(150);
    }

    @Test
    @DisplayName("소나타 자동차 생성_연비")
    void sonata_distance_per_liter(){
        Sonata sonata = new Sonata(150);
        assertThat(sonata.getDistancePerLiter()).isEqualTo(10.0);
    }

    @Test
    @DisplayName("소나타 자동차 생성_이름")
    void sonata_car_name(){
        Sonata sonata = new Sonata(150);
        assertThat(sonata.getName()).isEqualTo("Sonata");
    }
}
