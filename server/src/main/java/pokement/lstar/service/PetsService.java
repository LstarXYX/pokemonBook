package pokement.lstar.service;

import pokement.lstar.model.Pets;

import java.util.List;

/**
 * @author L.star
 * @date 2022/2/26 21:20
 */
public interface PetsService {

    List<Pets> queryAll();

    Pets queryOneByName(String name);

    List<Pets> queryOneByAttr(Integer attrone);

    int insertPet(Pets pets);

    int updatePet(Pets pets);

    int delPet(Integer recId);
}
