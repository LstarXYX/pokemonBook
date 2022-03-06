package pokement.lstar.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pokement.lstar.mapper.wxRecordMapper;
import pokement.lstar.model.wxRecord;
import pokement.lstar.service.wxRecordService;

/**
 * @author L.star
 * @date 2022/2/27 10:36
 */
@Service
public class WxRecordServiceImpl implements wxRecordService {

    @Autowired
    private wxRecordMapper wxRecordMapper;

    @Override
    public Integer createUser(wxRecord wxRecord) {
        return wxRecordMapper.insert(wxRecord);
    }

    @Override
    public wxRecord queryOne(wxRecord wxRecord) {
        return wxRecordMapper.selectOne(new QueryWrapper<wxRecord>().eq("unionId", wxRecord.getUnionId()).or().eq("rec_id", wxRecord.getRecId()));
    }

    @Override
    public Boolean exist(String unionId) {
        return wxRecordMapper.exists(new QueryWrapper<wxRecord>().eq("unionId", unionId));
    }
}
