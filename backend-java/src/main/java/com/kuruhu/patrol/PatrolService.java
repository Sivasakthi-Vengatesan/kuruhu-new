package com.kuruhu.patrol;

import java.util.List;

public interface PatrolService {
    Object assignBeat(Object param);
    Object trackPatrolVehicle(Object param);
    Object checkGeofenceViolations(Object param);
}
