package com.marlonviado.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.marlonviado.dto.ErrorDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
	
	private String status;
	private T response;
	private String customerNumber;
	private int transactionStatusCode;
	private String transactionStatusDescription;
	private List<ErrorDetailDTO> errors;

}