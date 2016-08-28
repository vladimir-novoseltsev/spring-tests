package com.raikiri.mapper.test;

import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.raikiri.mapper.test.dto.ListItemDTO;
import com.raikiri.mapper.test.model.dictionary.Currency;

@Configuration
public class ModelMapperConfiguration {

	private final static Logger LOG = Logger.getLogger(ModelMapperConfiguration.class);

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mm = new ModelMapper();
		LOG.info("Setup model mappings");
		mm.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);

		PropertyMap<Currency, ListItemDTO> currencyListItemMap = new PropertyMap<Currency, ListItemDTO>() {
			@Override
			protected void configure() {
				Converter<Currency, String> titleConverter = new AbstractConverter<Currency, String>() {
					@Override
					protected String convert(Currency source) {
						return MessageFormat.format("{0} : {1}", source.getCode(), source.getDescription());
					}
				};
				map().setId(source.getId());
				using(titleConverter).map(source).setTitle(null);
			}
		};

		mm.addMappings(currencyListItemMap);
		mm.validate();
		return mm;
	}
}
