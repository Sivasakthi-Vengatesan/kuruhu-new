package com.pramaan.service;

import com.pramaan.dto.CreateVehicleRequest;
import com.pramaan.dto.VehicleDto;
import com.pramaan.entity.Fir;
import com.pramaan.entity.Vehicle;
import com.pramaan.exception.ResourceNotFoundException;
import com.pramaan.repository.FirRepository;
import com.pramaan.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final FirRepository firRepository;
    private final ActivityService activityService;

    public VehicleService(VehicleRepository vehicleRepository, FirRepository firRepository, ActivityService activityService) {
        this.vehicleRepository = vehicleRepository;
        this.firRepository = firRepository;
        this.activityService = activityService;
    }


    @Transactional(readOnly = true)
    public List<VehicleDto> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with ID: " + id));
        return mapToDto(vehicle);
    }

    @Transactional
    public VehicleDto createVehicle(CreateVehicleRequest request) {
        Set<Fir> firs = new HashSet<>();
        if (request.getFirIds() != null) {
            for (Long fid : request.getFirIds()) {
                firRepository.findById(fid).ifPresent(firs::add);
            }
        }

        Vehicle vehicle = Vehicle.builder()
                .registrationNumber(request.getRegistrationNumber().toUpperCase().trim())
                .make(request.getMake())
                .model(request.getModel())
                .color(request.getColor())
                .registeredOwner(request.getRegisteredOwner())
                .firs(firs)
                .build();

        vehicle = vehicleRepository.save(vehicle);
        activityService.logActivity(null, "Registered Vehicle", vehicle.getRegistrationNumber(), "vehicle", "Vehicle entered into surveillance registry");

        return mapToDto(vehicle);
    }

    public VehicleDto mapToDto(Vehicle vehicle) {
        List<String> firIds = vehicle.getFirs().stream()
                .map(f -> String.valueOf(f.getId()))
                .collect(Collectors.toList());

        return VehicleDto.builder()
                .id(String.valueOf(vehicle.getId()))
                .registration(vehicle.getRegistrationNumber())
                .make(vehicle.getMake() != null ? vehicle.getMake() : "Vehicle")
                .color(vehicle.getColor() != null ? vehicle.getColor() : "Black")
                .firIds(firIds)
                .build();
    }
}