package pokement.lstar.service;

import pokement.lstar.model.wxRecord;

/**
 * @author L.star
 * @date 2022/2/27 10:35
 */
public interface wxRecordService {

    public Integer createUser(wxRecord wxRecord);

    public wxRecord queryOne(wxRecord wxRecord);

    public Boolean exist(String unionId);
}
