package com.selling.system.shared.module.convertors;

import com.selling.system.shared.module.models.commands.QueryField;
import com.selling.system.shared.module.models.commons.Range;
import com.selling.system.shared.module.models.entities.Customer;
import com.selling.system.shared.module.models.enums.FieldType;
import com.selling.system.shared.module.exceptions.BadConvertorException;
import com.selling.system.shared.module.exceptions.PayloadBadFormatException;

import java.util.LinkedHashMap;

public class ObjectToObjectsConvertor {

    /**
     * this method received an {@link Object} and converts to a {@link Range}<{@link Object}>.
     *
     * @param object {@link Object}
     * @return queryFiled: {@link Range}<{@link Object}>
     * @throws BadConvertorException if a problem happens while converting the received object to {@link Range}<{@link Object}>.
     * @author Abd Frehat
     * @since 1.0
     */
    public static Range<Object> toRange(Object object) {
        if (object instanceof LinkedHashMap<?, ?> list) {
            return new Range<>(list.get("min"), list.get("max"));
        }
        throw new BadConvertorException("Unable to convert the provided object to range");
    }

    /**
     * this method received an object and converts to a {@link QueryField} object.
     *
     * @param object {@link Object}
     * @return queryFiled: {@link QueryField}
     * @throws BadConvertorException if a problem happens while converting the received object to {@link QueryField}
     * @author Abd Frehat
     * @since 1.0
     */
    public static QueryField toQueryFiled(Object object) {
        try {
            if (object instanceof LinkedHashMap<?, ?> fieldsMap) {
                return QueryField.builder()
                        .field((String) fieldsMap.get("field"))
                        .value(fieldsMap.get("value"))
                        .fieldType(FieldType.valueOf((String) fieldsMap.get("fieldType")))
                        .build();
            } else {
                throw new BadConvertorException("Unable to convert the provided object to queryField");
            }
        } catch (Exception ex) {
            throw new BadConvertorException("Unable to convert the provided object to queryField");
        }
    }

}