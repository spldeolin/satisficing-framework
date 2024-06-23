package com.spldeolin.satisficing.security.service.design;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Multimap;
import com.spldeolin.allison1875.support.ByChainPredicate;
import com.spldeolin.allison1875.support.EntityKey;
import com.spldeolin.allison1875.support.OrderChainPredicate;
import com.spldeolin.satisficing.security.service.entity.UserEntity;

//@formatter:off
/**
 * 用户
 * <p>user
 * <p>
 * <p>Any modifications may be overwritten by future code generations.
 * <p>Allison 1875 Lot No: PG1001S-F7A47F26
 *
 * @author Allison 1875 2024-06-21
 */
@SuppressWarnings("all")
public class UserDesign {

    private final static UnsupportedOperationException e = new UnsupportedOperationException();

    private UserDesign() {
    }

    public static QueryChain query(String methodName) {
        throw e;
    }

    public static QueryChain query() {
        throw e;
    }

    public static UpdateChain update(String methodName) {
        throw e;
    }

    public static UpdateChain update() {
        throw e;
    }

    public static DropChain drop(String methodName) {
        throw e;
    }

    public static DropChain drop() {
        throw e;
    }

    public static class QueryChain {

        private QueryChain() {
        }

        /**
         * 主键
         */
        public QueryChain id;

        /**
         * 用户的UUID
         */
        public QueryChain userUuid;

        /**
         * 用户名
         */
        public QueryChain username;

        /**
         * 手机号
         */
        public QueryChain mobile;

        /**
         * 密码
         */
        public QueryChain password;

        /**
         * 用户昵称
         */
        public QueryChain nickName;

        /**
         * 插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1
         */
        public QueryChain createUserUuid;

        /**
         * 插入数据的时间
         */
        public QueryChain createTime;

        /**
         * 最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty
         */
        public QueryChain updateUserUuid;

        /**
         * 最近一次更新数据的时间。若数据从未更新过，与create_time保持一致
         */
        public QueryChain updateTime;

        public ByChainReturn<NextableByChainReturn> by() {
            throw e;
        }

        public ByChainReturn<NextableByChainReturn> byForced() {
            throw e;
        }

        public OrderChain order() {
            throw e;
        }

        public List<UserEntity> many() {
            throw e;
        }

        public <P> Map<P, UserEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, UserEntity> many(MultiEach<P> property) {
            throw e;
        }

        public UserEntity one() {
            throw e;
        }

        public int count() {
            throw e;
        }
    }

    public interface UpdateChain {

        /**
         * 主键
         */
        NextableUpdateChain id(Long id);

        /**
         * 用户的UUID
         */
        NextableUpdateChain userUuid(String userUuid);

        /**
         * 用户名
         */
        NextableUpdateChain username(String username);

        /**
         * 手机号
         */
        NextableUpdateChain mobile(String mobile);

        /**
         * 密码
         */
        NextableUpdateChain password(String password);

        /**
         * 用户昵称
         */
        NextableUpdateChain nickName(String nickName);

        /**
         * 插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1
         */
        NextableUpdateChain createUserUuid(String createUserUuid);

        /**
         * 插入数据的时间
         */
        NextableUpdateChain createTime(LocalDateTime createTime);

        /**
         * 最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty
         */
        NextableUpdateChain updateUserUuid(String updateUserUuid);

        /**
         * 最近一次更新数据的时间。若数据从未更新过，与create_time保持一致
         */
        NextableUpdateChain updateTime(LocalDateTime updateTime);
    }

    public interface NextableUpdateChain extends UpdateChain {

        int over();

        ByChainReturn<NextableByChainVoid> by();

        ByChainReturn<NextableByChainVoid> byForced();
    }

    public interface DropChain {

        int over();

        ByChainReturn<NextableByChainVoid> by();

        ByChainReturn<NextableByChainVoid> byForced();
    }

    public static class ByChainReturn<NEXT> {

        /**
         * 主键
         */
        public ByChainPredicate<NEXT, Long> id;

        /**
         * 用户的UUID
         */
        public ByChainPredicate<NEXT, String> userUuid;

        /**
         * 用户名
         */
        public ByChainPredicate<NEXT, String> username;

        /**
         * 手机号
         */
        public ByChainPredicate<NEXT, String> mobile;

        /**
         * 密码
         */
        public ByChainPredicate<NEXT, String> password;

        /**
         * 用户昵称
         */
        public ByChainPredicate<NEXT, String> nickName;

        /**
         * 插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1
         */
        public ByChainPredicate<NEXT, String> createUserUuid;

        /**
         * 插入数据的时间
         */
        public ByChainPredicate<NEXT, LocalDateTime> createTime;

        /**
         * 最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty
         */
        public ByChainPredicate<NEXT, String> updateUserUuid;

        /**
         * 最近一次更新数据的时间。若数据从未更新过，与create_time保持一致
         */
        public ByChainPredicate<NEXT, LocalDateTime> updateTime;
    }

    public static class NextableByChainReturn {

        /**
         * 主键
         */
        public ByChainPredicate<NextableByChainReturn, Long> id;

        /**
         * 用户的UUID
         */
        public ByChainPredicate<NextableByChainReturn, String> userUuid;

        /**
         * 用户名
         */
        public ByChainPredicate<NextableByChainReturn, String> username;

        /**
         * 手机号
         */
        public ByChainPredicate<NextableByChainReturn, String> mobile;

        /**
         * 密码
         */
        public ByChainPredicate<NextableByChainReturn, String> password;

        /**
         * 用户昵称
         */
        public ByChainPredicate<NextableByChainReturn, String> nickName;

        /**
         * 插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1
         */
        public ByChainPredicate<NextableByChainReturn, String> createUserUuid;

        /**
         * 插入数据的时间
         */
        public ByChainPredicate<NextableByChainReturn, LocalDateTime> createTime;

        /**
         * 最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty
         */
        public ByChainPredicate<NextableByChainReturn, String> updateUserUuid;

        /**
         * 最近一次更新数据的时间。若数据从未更新过，与create_time保持一致
         */
        public ByChainPredicate<NextableByChainReturn, LocalDateTime> updateTime;

        public List<UserEntity> many() {
            throw e;
        }

        public <P> Map<P, UserEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, UserEntity> many(MultiEach<P> property) {
            throw e;
        }

        public UserEntity one() {
            throw e;
        }

        public int count() {
            throw e;
        }

        public OrderChain order() {
            throw e;
        }
    }

    public static class NextableByChainVoid {

        /**
         * 主键
         */
        public ByChainPredicate<NextableByChainVoid, Long> id;

        /**
         * 用户的UUID
         */
        public ByChainPredicate<NextableByChainVoid, String> userUuid;

        /**
         * 用户名
         */
        public ByChainPredicate<NextableByChainVoid, String> username;

        /**
         * 手机号
         */
        public ByChainPredicate<NextableByChainVoid, String> mobile;

        /**
         * 密码
         */
        public ByChainPredicate<NextableByChainVoid, String> password;

        /**
         * 用户昵称
         */
        public ByChainPredicate<NextableByChainVoid, String> nickName;

        /**
         * 插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1
         */
        public ByChainPredicate<NextableByChainVoid, String> createUserUuid;

        /**
         * 插入数据的时间
         */
        public ByChainPredicate<NextableByChainVoid, LocalDateTime> createTime;

        /**
         * 最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty
         */
        public ByChainPredicate<NextableByChainVoid, String> updateUserUuid;

        /**
         * 最近一次更新数据的时间。若数据从未更新过，与create_time保持一致
         */
        public ByChainPredicate<NextableByChainVoid, LocalDateTime> updateTime;

        public int over() {
            throw e;
        }
    }

    public static class OrderChain {

        /**
         * 主键
         */
        public OrderChainPredicate<NextableOrderChain> id;

        /**
         * 用户的UUID
         */
        public OrderChainPredicate<NextableOrderChain> userUuid;

        /**
         * 用户名
         */
        public OrderChainPredicate<NextableOrderChain> username;

        /**
         * 手机号
         */
        public OrderChainPredicate<NextableOrderChain> mobile;

        /**
         * 密码
         */
        public OrderChainPredicate<NextableOrderChain> password;

        /**
         * 用户昵称
         */
        public OrderChainPredicate<NextableOrderChain> nickName;

        /**
         * 插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1
         */
        public OrderChainPredicate<NextableOrderChain> createUserUuid;

        /**
         * 插入数据的时间
         */
        public OrderChainPredicate<NextableOrderChain> createTime;

        /**
         * 最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty
         */
        public OrderChainPredicate<NextableOrderChain> updateUserUuid;

        /**
         * 最近一次更新数据的时间。若数据从未更新过，与create_time保持一致
         */
        public OrderChainPredicate<NextableOrderChain> updateTime;
    }

    public static class NextableOrderChain extends OrderChain {

        public List<UserEntity> many() {
            throw e;
        }

        public <P> Map<P, UserEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, UserEntity> many(MultiEach<P> property) {
            throw e;
        }

        public UserEntity one() {
            throw e;
        }

        public int count() {
            throw e;
        }
    }

    public interface Each<P> {

        Each<Long> id = (Each<Long>) new Object();

        Each<String> userUuid = (Each<String>) new Object();

        Each<String> username = (Each<String>) new Object();

        Each<String> mobile = (Each<String>) new Object();

        Each<String> password = (Each<String>) new Object();

        Each<String> nickName = (Each<String>) new Object();

        Each<String> createUserUuid = (Each<String>) new Object();

        Each<LocalDateTime> createTime = (Each<LocalDateTime>) new Object();

        Each<String> updateUserUuid = (Each<String>) new Object();

        Each<LocalDateTime> updateTime = (Each<LocalDateTime>) new Object();
    }

    public interface MultiEach<P> {

        MultiEach<Long> id = (MultiEach<Long>) new Object();

        MultiEach<String> userUuid = (MultiEach<String>) new Object();

        MultiEach<String> username = (MultiEach<String>) new Object();

        MultiEach<String> mobile = (MultiEach<String>) new Object();

        MultiEach<String> password = (MultiEach<String>) new Object();

        MultiEach<String> nickName = (MultiEach<String>) new Object();

        MultiEach<String> createUserUuid = (MultiEach<String>) new Object();

        MultiEach<LocalDateTime> createTime = (MultiEach<LocalDateTime>) new Object();

        MultiEach<String> updateUserUuid = (MultiEach<String>) new Object();

        MultiEach<LocalDateTime> updateTime = (MultiEach<LocalDateTime>) new Object();
    }

    public static EntityKey<UserEntity, Long> id;

    public static EntityKey<UserEntity, String> userUuid;

    public static EntityKey<UserEntity, String> username;

    public static EntityKey<UserEntity, String> mobile;

    public static EntityKey<UserEntity, String> password;

    public static EntityKey<UserEntity, String> nickName;

    public static EntityKey<UserEntity, String> createUserUuid;

    public static EntityKey<UserEntity, LocalDateTime> createTime;

    public static EntityKey<UserEntity, String> updateUserUuid;

    public static EntityKey<UserEntity, LocalDateTime> updateTime;

    String meta = "{\"entityQualifier\":\"com.spldeolin.satisficing.security.service.entity.UserEntity\",\"entityName\":\"UserEntity\",\"mapperQualifier\":\"com.spldeolin.satisficing.security.service.mapper.UserMapper\",\"mapperName\":\"UserMapper\",\"mapperRelativePaths\":[\"../resources/mapper/UserMapper.xml\"],\"properties\":{\"password\":{\"columnName\":\"password\",\"propertyName\":\"password\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"密码\",\"length\":255,\"notnull\":true,\"defaultV\":null},\"updateUserUuid\":{\"columnName\":\"update_user_uuid\",\"propertyName\":\"updateUserUuid\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty\",\"length\":36,\"notnull\":true,\"defaultV\":\"\"},\"createTime\":{\"columnName\":\"create_time\",\"propertyName\":\"createTime\",\"javaType\":{\"simpleName\":\"LocalDateTime\",\"qualifier\":\"java.time.LocalDateTime\"},\"description\":\"插入数据的时间\",\"length\":null,\"notnull\":true,\"defaultV\":\"CURRENT_TIMESTAMP\"},\"nickName\":{\"columnName\":\"nick_name\",\"propertyName\":\"nickName\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"用户昵称\",\"length\":255,\"notnull\":true,\"defaultV\":null},\"userUuid\":{\"columnName\":\"user_uuid\",\"propertyName\":\"userUuid\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"用户的UUID\",\"length\":36,\"notnull\":true,\"defaultV\":null},\"mobile\":{\"columnName\":\"mobile\",\"propertyName\":\"mobile\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"手机号\",\"length\":255,\"notnull\":true,\"defaultV\":null},\"createUserUuid\":{\"columnName\":\"create_user_uuid\",\"propertyName\":\"createUserUuid\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1\",\"length\":36,\"notnull\":true,\"defaultV\":\"\"},\"updateTime\":{\"columnName\":\"update_time\",\"propertyName\":\"updateTime\",\"javaType\":{\"simpleName\":\"LocalDateTime\",\"qualifier\":\"java.time.LocalDateTime\"},\"description\":\"最近一次更新数据的时间。若数据从未更新过，与create_time保持一致\",\"length\":null,\"notnull\":true,\"defaultV\":\"CURRENT_TIMESTAMP\"},\"id\":{\"columnName\":\"id\",\"propertyName\":\"id\",\"javaType\":{\"simpleName\":\"Long\",\"qualifier\":\"java.lang.Long\"},\"description\":\"主键\",\"length\":null,\"notnull\":true,\"defaultV\":null},\"username\":{\"columnName\":\"username\",\"propertyName\":\"username\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"用户名\",\"length\":255,\"notnull\":true,\"defaultV\":null}},\"tableName\":\"user\",\"notDeletedSql\":null}";
}
//59aa55c7415f09daa35201de700f1d3a
