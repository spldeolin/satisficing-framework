package com.spldeolin.satisficing.security.service.javabean.resp;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * <p>Allison 1875 Lot No: HT1001S-77216521
 *
 * @author Deolin 2024-06-03
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ListUsersRespDto {

    String userUuid;

    String username;

    String mobile;

    String nickName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    LocalDateTime createTime;

    List<String> roleNames;

}
