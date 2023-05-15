package com.mysite.Petopia.Map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "place_info")
public class MapDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facility_name")
    private String facilityName;

    @Column(name = "category1")
    private String category1;

    @Column(name = "category2")
    private String category2;

    @Column(name = "category3")
    private String category3;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "county_name")
    private String countyName;

    @Column(name = "town_name")
    private String townName;

    @Column(name = "village_name")
    private String villageName;

    @Column(name = "address_number")
    private String addressNumber;

    @Column(name = "road_name")
    private String roadName;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "lng")
    private Double longitude;

    @Column(name = "postal_code")
    private Integer postalCode;

    @Column(name = "road_address")
    private String roadAddress;

    @Column(name = "lot_address")
    private String lotAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "homepage")
    private String homepage;

    @Column(name = "holiday")
    private String holiday;

    @Column(name = "operation_time")
    private String operationTime;

    @Column(name = "parking_info")
    private String parkingInfo;

    @Column(name = "admission_price_info")
    private String admissionPriceInfo;

    @Column(name = "pet_companion_info")
    private String petCompanionInfo;

    @Column(name = "pet_only_info")
    private String petOnlyInfo;

    @Column(name = "animal_size_info")
    private String animalSizeInfo;

    @Column(name = "pet_restriction_info")
    private String petRestrictionInfo;

    @Column(name = "indoor_facility_info")
    private String indoorFacilityInfo;

    @Column(name = "outdoor_facility_info")
    private String outdoorFacilityInfo;

    @Column(name = "place_description")
    private String placeDescription;

    @Column(name = "pet_companion_additional_fee")
    private String petCompanionAdditionalFee;

    @Column(name = "last_updated_date")
    private String lastUpdatedDate;
}
