package br.ufrn.imd.learningplatform.mapper.modelMapper;

import br.ufrn.imd.learningplatform.mapper.Mapper;
import br.ufrn.imd.learningplatform.mapper.modelMapper.config.ModelMapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyModelMapper implements Mapper {

    private final ModelMapper modelMapper = new ModelMapperConfig().modelMapper();

    public <O, D> D convertValue(O origin, Class<D> destination) {
        return modelMapper.map(origin, destination);
    }

    public <O, D> List<D> convertList(List<O> origins, Class<D> destination) {

        List<D> destinations = new ArrayList<>();

        origins.stream().map(origin -> convertValue(origin, destination)).forEach(destinations::add);

        return destinations;
    }
}
