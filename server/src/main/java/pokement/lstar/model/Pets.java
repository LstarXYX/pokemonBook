package pokement.lstar.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 宠物精灵
 * @author L.star
 * @date 2022/2/26 21:15
 */
@Data
@ToString
@TableName(value = "pets")
public class Pets implements Serializable {
    private static final long serialVersionUID = -5644799954031156649L;

    @TableId(value = "rec_id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String no;
    private String imageUrl;
    private Integer attrOne;
    private Integer attrTwo;
}
