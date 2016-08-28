package com.raikiri.mapper.test.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raikiri.mapper.test.dao.CurrenciesRepository;
import com.raikiri.mapper.test.dto.CurrencyDTO;
import com.raikiri.mapper.test.dto.ListItemDTO;

@RestController
@RequestMapping("/api/currencies")
public class CurrenciesResource {

    @Autowired
    private CurrenciesRepository currenciesRepo;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ListItemDTO> currenciesList() {
        return currenciesRepo.findAll().stream().map(cur -> modelMapper.map(cur, ListItemDTO.class))
                .collect(Collectors.toList());
    }

    @RequestMapping(path = "/details", method = RequestMethod.GET)
    public Collection<CurrencyDTO> currenciesWithDetails() {
        return currenciesRepo.findAll().stream().map(cur -> modelMapper.map(cur, CurrencyDTO.class))
                .collect(Collectors.toList());
    }
}
