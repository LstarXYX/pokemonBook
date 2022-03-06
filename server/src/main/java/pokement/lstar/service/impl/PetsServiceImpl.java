package pokement.lstar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokement.lstar.mapper.PetsMapper;
import pokement.lstar.model.Pets;
import pokement.lstar.service.PetsService;

import java.util.List;

/**
 * @author L.star
 * @date 2022/2/26 21:21
 */
@Service
public class PetsServiceImpl implements PetsService {

    @Autowired
    private PetsMapper petsMapper;

    @Override
    public List<Pets> queryAll() {
        return petsMapper.selectList(null);
    }

    @Override
    public Pets queryOneByName(String name) {
        return petsMapper.selectOne(new QueryWrapper<Pets>().like("name",name));
    }

    @Override
    public List<Pets> queryOneByAttr(Integer attrone) {
        return petsMapper.selectList(new QueryWrapper<Pets>().eq("attr_one", attrone));
    }

    @Override
    public int insertPet(Pets pets) {
        return petsMapper.insert(pets);
    }

    @Override
    public int updatePet(Pets pets) {
        return petsMapper.updateById(pets);
    }

    @Override
    public int delPet(Integer recId) {
        return petsMapper.deleteById(recId);
    }
}
