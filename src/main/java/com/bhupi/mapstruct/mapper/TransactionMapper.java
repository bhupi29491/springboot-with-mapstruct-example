package com.bhupi.mapstruct.mapper;

import com.bhupi.mapstruct.dto.TransactionDTO;
import com.bhupi.mapstruct.dto.TransactionViewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @ValueMapping(source = "NETBANKING", target = "NET_BANKING")
//    @ValueMapping(source = "CREDIT_CARD", target = "CARD")
//    @ValueMapping(source = "DEBIT_CARD", target = "CARD")
//    @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CARD")
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "CARD")

    @Mapping(source = "paymentType", target = "paymentViewType")
    TransactionViewDTO toViewDTO(TransactionDTO transactionDTO);
}
