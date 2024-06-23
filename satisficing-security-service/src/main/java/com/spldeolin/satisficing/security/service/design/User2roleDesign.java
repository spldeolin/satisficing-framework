package com.spldeolin.satisficing.security.service.design;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Multimap;
import com.spldeolin.allison1875.support.ByChainPredicate;
import com.spldeolin.allison1875.support.EntityKey;
import com.spldeolin.allison1875.support.OrderChainPredicate;
import com.spldeolin.satisficing.security.service.entity.User2roleEntity;

//@formatter:off
/**
 * 用户与角色的关联关系
 * <p>user2role
 * <p>
 * <p>Any modifications may be overwritten by future code generations.
 * <p>Allison 1875 Lot No: PG1001S-5474455B
 *
 * @author Allison 1875 2024-06-21
 */
@SuppressWarnings("all")
public class User2roleDesign {

    private final static UnsupportedOperationException e = new UnsupportedOperationException();

    private User2roleDesign() {
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
         * 用户ID
         */
        public QueryChain userId;

        /**
         * 角色ID
         */
        public QueryChain roleId;

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

        public List<User2roleEntity> many() {
            throw e;
        }

        public <P> Map<P, User2roleEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, User2roleEntity> many(MultiEach<P> property) {
            throw e;
        }

        public User2roleEntity one() {
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
         * 用户ID
         */
        NextableUpdateChain userId(Long userId);

        /**
         * 角色ID
         */
        NextableUpdateChain roleId(Long roleId);

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
         * 用户ID
         */
        public ByChainPredicate<NEXT, Long> userId;

        /**
         * 角色ID
         */
        public ByChainPredicate<NEXT, Long> roleId;

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
         * 用户ID
         */
        public ByChainPredicate<NextableByChainReturn, Long> userId;

        /**
         * 角色ID
         */
        public ByChainPredicate<NextableByChainReturn, Long> roleId;

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

        public List<User2roleEntity> many() {
            throw e;
        }

        public <P> Map<P, User2roleEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, User2roleEntity> many(MultiEach<P> property) {
            throw e;
        }

        public User2roleEntity one() {
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
         * 用户ID
         */
        public ByChainPredicate<NextableByChainVoid, Long> userId;

        /**
         * 角色ID
         */
        public ByChainPredicate<NextableByChainVoid, Long> roleId;

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
         * 用户ID
         */
        public OrderChainPredicate<NextableOrderChain> userId;

        /**
         * 角色ID
         */
        public OrderChainPredicate<NextableOrderChain> roleId;

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

        public List<User2roleEntity> many() {
            throw e;
        }

        public <P> Map<P, User2roleEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, User2roleEntity> many(MultiEach<P> property) {
            throw e;
        }

        public User2roleEntity one() {
            throw e;
        }

        public int count() {
            throw e;
        }
    }

    public interface Each<P> {

        Each<Long> id = (Each<Long>) new Object();

        Each<Long> userId = (Each<Long>) new Object();

        Each<Long> roleId = (Each<Long>) new Object();

        Each<String> createUserUuid = (Each<String>) new Object();

        Each<LocalDateTime> createTime = (Each<LocalDateTime>) new Object();

        Each<String> updateUserUuid = (Each<String>) new Object();

        Each<LocalDateTime> updateTime = (Each<LocalDateTime>) new Object();
    }

    public interface MultiEach<P> {

        MultiEach<Long> id = (MultiEach<Long>) new Object();

        MultiEach<Long> userId = (MultiEach<Long>) new Object();

        MultiEach<Long> roleId = (MultiEach<Long>) new Object();

        MultiEach<String> createUserUuid = (MultiEach<String>) new Object();

        MultiEach<LocalDateTime> createTime = (MultiEach<LocalDateTime>) new Object();

        MultiEach<String> updateUserUuid = (MultiEach<String>) new Object();

        MultiEach<LocalDateTime> updateTime = (MultiEach<LocalDateTime>) new Object();
    }

    public static EntityKey<User2roleEntity, Long> id;

    public static EntityKey<User2roleEntity, Long> userId;

    public static EntityKey<User2roleEntity, Long> roleId;

    public static EntityKey<User2roleEntity, String> createUserUuid;

    public static EntityKey<User2roleEntity, LocalDateTime> createTime;

    public static EntityKey<User2roleEntity, String> updateUserUuid;

    public static EntityKey<User2roleEntity, LocalDateTime> updateTime;

    String meta = "{\"entityQualifier\":\"com.spldeolin.satisficing.security.service.entity.User2roleEntity\",\"entityName\":\"User2roleEntity\",\"mapperQualifier\":\"com.spldeolin.satisficing.security.service.mapper.User2roleMapper\",\"mapperName\":\"User2roleMapper\",\"mapperRelativePaths\":[\"../resources/mapper/User2roleMapper.xml\"],\"properties\":{\"updateUserUuid\":{\"columnName\":\"update_user_uuid\",\"propertyName\":\"updateUserUuid\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty\",\"length\":36,\"notnull\":true,\"defaultV\":\"\"},\"createTime\":{\"columnName\":\"create_time\",\"propertyName\":\"createTime\",\"javaType\":{\"simpleName\":\"LocalDateTime\",\"qualifier\":\"java.time.LocalDateTime\"},\"description\":\"插入数据的时间\",\"length\":null,\"notnull\":true,\"defaultV\":\"CURRENT_TIMESTAMP\"},\"roleId\":{\"columnName\":\"role_id\",\"propertyName\":\"roleId\",\"javaType\":{\"simpleName\":\"Long\",\"qualifier\":\"java.lang.Long\"},\"description\":\"角色ID\",\"length\":null,\"notnull\":true,\"defaultV\":null},\"createUserUuid\":{\"columnName\":\"create_user_uuid\",\"propertyName\":\"createUserUuid\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1\",\"length\":36,\"notnull\":true,\"defaultV\":\"\"},\"updateTime\":{\"columnName\":\"update_time\",\"propertyName\":\"updateTime\",\"javaType\":{\"simpleName\":\"LocalDateTime\",\"qualifier\":\"java.time.LocalDateTime\"},\"description\":\"最近一次更新数据的时间。若数据从未更新过，与create_time保持一致\",\"length\":null,\"notnull\":true,\"defaultV\":\"CURRENT_TIMESTAMP\"},\"id\":{\"columnName\":\"id\",\"propertyName\":\"id\",\"javaType\":{\"simpleName\":\"Long\",\"qualifier\":\"java.lang.Long\"},\"description\":\"主键\",\"length\":null,\"notnull\":true,\"defaultV\":null},\"userId\":{\"columnName\":\"user_id\",\"propertyName\":\"userId\",\"javaType\":{\"simpleName\":\"Long\",\"qualifier\":\"java.lang.Long\"},\"description\":\"用户ID\",\"length\":null,\"notnull\":true,\"defaultV\":null}},\"tableName\":\"user2role\",\"notDeletedSql\":null}";
}
//f801632dfbbaec91ffa73b534e4cabff
