package br.com.gransistemas.taurus.repository.specification;

import br.com.gransistemas.taurus.model.Device;
import org.springframework.data.jpa.domain.Specification;

import java.util.Objects;

public class DeviceSpecification {
    public static Specification<Device> id(Long id) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if(Objects.isNull(id))
                return null;

            return criteriaBuilder.equal(root.get("id"), id);
        };
    }

    public static Specification<Device> name(String name) {
        return (root, criteriaQuery, builder) -> {
            if(Objects.isNull(name))
                return null;

            return builder.like(builder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    public static Specification<Device> imei(String imei) {
        return (root, criteriaQuery, builder) -> {
            if(Objects.isNull(imei))
                return null;

            return builder.like(builder.lower(root.get("imei")), "%" + imei.toLowerCase() + "%");
        };
    }
}
