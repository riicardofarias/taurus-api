package br.com.gransistemas.taurus.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável por ajudar no retorno dos dados para a view
 * @author Ricardo Farias
 * @since release 1
 */
public class Success implements Serializable{
	private Map<String, Object> attrs = new HashMap<>();

	public Success withError(){
		return withError("Unknown error occurred");
	}

	public Success withError(Object result){
		attrs.put("error", result);
		return this;
	}

	public Success withMessage(Object result){
		attrs.put("message", result);
		return this;
	}

	public Success withAttr(String key, Object value){
		attrs.put(key, value);
		return this;
	}

	public Map<String, Object> asObject(){
		return attrs;
	}

	public String asJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

		return mapper.writeValueAsString(attrs);
	}
}
