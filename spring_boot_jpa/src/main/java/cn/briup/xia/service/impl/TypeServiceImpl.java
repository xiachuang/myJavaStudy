package cn.briup.xia.service.impl;

import cn.briup.xia.baen.Type;
import cn.briup.xia.exception.MyException;
import cn.briup.xia.repository.TypeRepository;
import cn.briup.xia.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public List<Type> findByAll() {
        List<Type> types=typeRepository.findAll();
        return types;
    }

    @Override
    public Type findTypeById(Integer id) {
        Specification<Type> spec=new Specification<Type>() {
            @Override
            public Predicate toPredicate(Root<Type> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Path<Object> id= root.get("id");
            Predicate predicate=criteriaBuilder.equal(id,id);
            return predicate;
            }
        };
        Optional<Type> otype=typeRepository.findOne(spec);
        if(otype.isPresent()){
            return  otype.get();
        }else{
            throw  new MyException();
        }
    }

    @Override
    public void insertType(Type type) {
    typeRepository.save(type);
    }
}
