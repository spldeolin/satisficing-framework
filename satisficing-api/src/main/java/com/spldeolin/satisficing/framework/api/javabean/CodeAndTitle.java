package com.spldeolin.satisficing.framework.api.javabean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author Deolin 2020-08-27
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CodeAndTitle {

    /**
     * 枚举code
     */
    final Object code;

    /**
     * 枚举标题
     */
    final String title;

}