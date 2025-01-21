package br.ufrn.imd.yulearn.mapper;

import java.util.List;

public interface Mapper {

    <O, D> D convertValue(O origin, Class<D> destination);
    <O, D> List<D> convertList(List<O> origins, Class<D> destination);

}
