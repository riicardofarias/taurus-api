package br.com.gransistemas.taurus.util.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by ricardo.lima on 09/10/19.
 */
@Component
public class Mapper {
    public static <T> T as(String json, Class<T> clazz) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> T as(String json, TypeReference<T> type) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, type);
        } catch (IOException e) {
            return null;
        }
    }
}
