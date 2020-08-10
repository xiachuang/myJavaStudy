package cn.briup.xia.service.impl;

import cn.briup.xia.baen.Comic;
import cn.briup.xia.exception.MyException;
import cn.briup.xia.repository.ComIcRepository;
import cn.briup.xia.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ComicServiceImpl  implements ComicService {
    @Autowired
    public ComIcRepository comIcRepository;
    @Override
    public List<Comic> findByAll() {
        List<Comic> comics=comIcRepository.findAll();
        return comics;
    }

    @Override
    public List<Comic> findByComicNameLike(String name) {
        Specification<Comic> spec=new Specification<Comic>() {
            @Override
            public Predicate toPredicate(Root<Comic> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            Path<Object> comicName= root.get("comicName");
            Predicate predicate=criteriaBuilder.like(comicName.as(String.class),"%"+name+"%");
            return  predicate;
            }
        };
        List<Comic> comics=comIcRepository.findAll(spec);
        return comics;
    }

    @Override
    public Comic findComicById( Integer comicId) {
        Optional<Comic> comics=comIcRepository.findById(comicId);
        if (comics.isPresent()){
            return  comics.get();
        }else {
            throw  new MyException();
        }

    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean insertComic(Comic comic) {
        comIcRepository.save(comic);
        Boolean bl=true;
        return bl;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean deleteComicById(Integer comicid) {
        comIcRepository.deleteById(comicid);
        Boolean bl=true;
        return bl;
    }

    @Override
    @Transactional
    @Rollback(false)
    public Boolean updateComic(Comic comic) {
        comIcRepository.save(comic);
        Boolean bl=true;
        return bl;
    }
}
