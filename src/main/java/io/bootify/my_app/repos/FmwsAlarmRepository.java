package io.bootify.my_app.repos;

import io.bootify.my_app.domain.FmwsAlarm;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FmwsAlarmRepository extends JpaRepository<FmwsAlarm, String> {
}
