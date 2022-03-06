package pokement.lstar.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author L.star
 * @date 2022/2/27 11:14
 */
@Data
@ToString
@Accessors(chain = true)
@TableName(value = "user")
public class User implements Serializable {

    @TableId(value = "rec_id", type = IdType.AUTO)
    private Integer recId;
    private String name;
    private String pwd;
    private String salt;
    private Date modified;
    private Date created;
}
