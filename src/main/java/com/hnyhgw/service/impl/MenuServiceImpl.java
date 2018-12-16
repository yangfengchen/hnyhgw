package com.hnyhgw.service.impl;

import com.google.common.collect.Lists;
import com.hnyhgw.dto.CommonRequestParamDto;
import com.hnyhgw.entity.MenuEntity;
import com.hnyhgw.repository.AbstractBaseRepository;
import com.hnyhgw.repository.MenuRepository;
import com.hnyhgw.service.MenuService;
import com.hnyhgw.vo.MenuVo;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends AbstractBaseServiceImpl<MenuEntity,String> implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public static final BeanCopier copier = BeanCopier.create(MenuEntity.class, MenuVo.class, false);

    @Override
    public AbstractBaseRepository<MenuEntity, String> getAbstractBaseRepository() {
        return menuRepository;
    }

    @Override
    public List<MenuVo> findMenuVoByAll() {
        List<MenuEntity> lists = this.findAll();
        List<MenuVo> voLists = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(lists)){
            for(MenuEntity menuEntity : lists){
                MenuVo menuVo = new MenuVo();
                copier.copy(menuEntity,menuVo,null);
                voLists.add(menuVo);
            }
        }
        return voLists;
    }

    @Override
    public Page<MenuEntity> findByPage(CommonRequestParamDto requestParamDto) {
        return null;
    }
}
