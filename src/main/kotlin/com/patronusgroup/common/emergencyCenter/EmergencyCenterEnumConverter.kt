package com.patronusgroup.common.emergencyCenter

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class EmergencyCenterEnumConverter : AttributeConverter<EmergencyCenterEnum, String> {

    override fun convertToDatabaseColumn(attribute: EmergencyCenterEnum?): String? =
        attribute?.databaseValue

    override fun convertToEntityAttribute(dbData: String?): EmergencyCenterEnum? =
        dbData?.let { value ->
            EmergencyCenterEnum.entries.firstOrNull { it.databaseValue == value }
                ?: throw IllegalArgumentException("Unknown emergency center name in DB: $value")
        }
}