package pokement.lstar.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author L.star
 * @date 2022/2/27 10:06
 */
@Data
@ToString
@Accessors(chain = true)
@TableName(value = "wx_record")
public class wxRecord implements Serializable {

    @TableId(value = "rec_id", type = IdType.AUTO)
    private Integer recId;
    private String unionId;
}
