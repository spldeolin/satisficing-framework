package com.spldeolin.satisficing.security.service.javabean.resp;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * <p>Allison 1875 Lot No: HT1001S-D3209C95
 *
 * @author Deolin 2024-06-03
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class CreateUserRespDto implements Serializable, Cloneable {

    private static final long serialVersionUID = 8942692205524887210L;

    /**
     * 用户的UUID
     */
    String userUuid;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
