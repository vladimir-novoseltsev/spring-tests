package com.raikiri.mapper.test.api;

import java.util.Collection;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
	public Collection<ListItemDTO> currenciesList(
			@RequestParam(name = "disabled", required = false, defaultValue = "false") Boolean disabled) {
        return currenciesRepo.findByDisabled(disabled).stream().map(cur -> modelMapper.map(cur, ListItemDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/details")
    public Collection<CurrencyDTO> currenciesWithDetails() {
        return currenciesRepo.findAll().stream().map(cur -> modelMapper.map(cur, CurrencyDTO.class))
                .collect(Collectors.toList());
    }
}
