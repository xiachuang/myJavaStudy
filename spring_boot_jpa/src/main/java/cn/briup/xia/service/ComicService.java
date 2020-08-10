package cn.briup.xia.service;

import cn.briup.xia.baen.Comic;

import java.util.List;
import java.util.Set;

public interface ComicService {
    public List<Comic> findByAll();
    public  List<Comic> findByComicNameLike(String name);
    //查看详情
    public Comic findComicById( Integer comicId);
    public Boolean insertComic(Comic comic);
    public Boolean deleteComicById(Integer id);
    public  Boolean updateComic(Comic comic);
}
