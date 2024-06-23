package com.spldeolin.satisficing.security.service.design;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.google.common.collect.Multimap;
import com.spldeolin.allison1875.support.ByChainPredicate;
import com.spldeolin.allison1875.support.EntityKey;
import com.spldeolin.allison1875.support.OrderChainPredicate;
import com.spldeolin.satisficing.security.service.entity.DepartmentEntity;

//@formatter:off
/**
 * 部门
 * <p>department
 * <p>
 * <p>Any modifications may be overwritten by future code generations.
 *
 * @author Allison 1875 2024-06-23
 */
@SuppressWarnings("all")
public class DepartmentDesign {

    private final static UnsupportedOperationException e = new UnsupportedOperationException();

    private DepartmentDesign() {
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
         * 部门名称
         */
        public QueryChain departmentName;

        /**
         * 主键路径
         */
        public QueryChain path;

        /**
         * 上级部门ID
         */
        public QueryChain parentId;

        /**
         * 描述
         */
        public QueryChain description;

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

        public List<DepartmentEntity> many() {
            throw e;
        }

        public <P> Map<P, DepartmentEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, DepartmentEntity> many(MultiEach<P> property) {
            throw e;
        }

        public DepartmentEntity one() {
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
         * 部门名称
         */
        NextableUpdateChain departmentName(String departmentName);

        /**
         * 主键路径
         */
        NextableUpdateChain path(String path);

        /**
         * 上级部门ID
         */
        NextableUpdateChain parentId(String parentId);

        /**
         * 描述
         */
        NextableUpdateChain description(String description);

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
         * 部门名称
         */
        public ByChainPredicate<NEXT, String> departmentName;

        /**
         * 主键路径
         */
        public ByChainPredicate<NEXT, String> path;

        /**
         * 上级部门ID
         */
        public ByChainPredicate<NEXT, String> parentId;

        /**
         * 描述
         */
        public ByChainPredicate<NEXT, String> description;

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
         * 部门名称
         */
        public ByChainPredicate<NextableByChainReturn, String> departmentName;

        /**
         * 主键路径
         */
        public ByChainPredicate<NextableByChainReturn, String> path;

        /**
         * 上级部门ID
         */
        public ByChainPredicate<NextableByChainReturn, String> parentId;

        /**
         * 描述
         */
        public ByChainPredicate<NextableByChainReturn, String> description;

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

        public List<DepartmentEntity> many() {
            throw e;
        }

        public <P> Map<P, DepartmentEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, DepartmentEntity> many(MultiEach<P> property) {
            throw e;
        }

        public DepartmentEntity one() {
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
         * 部门名称
         */
        public ByChainPredicate<NextableByChainVoid, String> departmentName;

        /**
         * 主键路径
         */
        public ByChainPredicate<NextableByChainVoid, String> path;

        /**
         * 上级部门ID
         */
        public ByChainPredicate<NextableByChainVoid, String> parentId;

        /**
         * 描述
         */
        public ByChainPredicate<NextableByChainVoid, String> description;

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
         * 部门名称
         */
        public OrderChainPredicate<NextableOrderChain> departmentName;

        /**
         * 主键路径
         */
        public OrderChainPredicate<NextableOrderChain> path;

        /**
         * 上级部门ID
         */
        public OrderChainPredicate<NextableOrderChain> parentId;

        /**
         * 描述
         */
        public OrderChainPredicate<NextableOrderChain> description;

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

        public List<DepartmentEntity> many() {
            throw e;
        }

        public <P> Map<P, DepartmentEntity> many(Each<P> property) {
            throw e;
        }

        public <P> Multimap<P, DepartmentEntity> many(MultiEach<P> property) {
            throw e;
        }

        public DepartmentEntity one() {
            throw e;
        }

        public int count() {
            throw e;
        }
    }

    public interface Each<P> {

        Each<Long> id = (Each<Long>) new Object();

        Each<String> departmentName = (Each<String>) new Object();

        Each<String> path = (Each<String>) new Object();

        Each<String> parentId = (Each<String>) new Object();

        Each<String> description = (Each<String>) new Object();

        Each<String> createUserUuid = (Each<String>) new Object();

        Each<LocalDateTime> createTime = (Each<LocalDateTime>) new Object();

        Each<String> updateUserUuid = (Each<String>) new Object();

        Each<LocalDateTime> updateTime = (Each<LocalDateTime>) new Object();
    }

    public interface MultiEach<P> {

        MultiEach<Long> id = (MultiEach<Long>) new Object();

        MultiEach<String> departmentName = (MultiEach<String>) new Object();

        MultiEach<String> path = (MultiEach<String>) new Object();

        MultiEach<String> parentId = (MultiEach<String>) new Object();

        MultiEach<String> description = (MultiEach<String>) new Object();

        MultiEach<String> createUserUuid = (MultiEach<String>) new Object();

        MultiEach<LocalDateTime> createTime = (MultiEach<LocalDateTime>) new Object();

        MultiEach<String> updateUserUuid = (MultiEach<String>) new Object();

        MultiEach<LocalDateTime> updateTime = (MultiEach<LocalDateTime>) new Object();
    }

    public static EntityKey<DepartmentEntity, Long> id;

    public static EntityKey<DepartmentEntity, String> departmentName;

    public static EntityKey<DepartmentEntity, String> path;

    public static EntityKey<DepartmentEntity, String> parentId;

    public static EntityKey<DepartmentEntity, String> description;

    public static EntityKey<DepartmentEntity, String> createUserUuid;

    public static EntityKey<DepartmentEntity, LocalDateTime> createTime;

    public static EntityKey<DepartmentEntity, String> updateUserUuid;

    public static EntityKey<DepartmentEntity, LocalDateTime> updateTime;

    String meta = "{\"entityQualifier\":\"com.spldeolin.satisficing.security.service.entity.DepartmentEntity\",\"entityName\":\"DepartmentEntity\",\"mapperQualifier\":\"com.spldeolin.satisficing.security.service.mapper.DepartmentMapper\",\"mapperName\":\"DepartmentMapper\",\"mapperRelativePaths\":[\"../resources/mapper/DepartmentMapper.xml\"],\"properties\":{\"departmentName\":{\"columnName\":\"department_name\",\"propertyName\":\"departmentName\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"部门名称\",\"length\":255,\"notnull\":true,\"defaultV\":null},\"path\":{\"columnName\":\"path\",\"propertyName\":\"path\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"主键路径\",\"length\":255,\"notnull\":true,\"defaultV\":null},\"updateUserUuid\":{\"columnName\":\"update_user_uuid\",\"propertyName\":\"updateUserUuid\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"最近一次更新数据时登录者的userUuid。若数据从未更新过，值与create_staff_uuid保持一致；若数据并非登录者更新的，值为empty\",\"length\":36,\"notnull\":true,\"defaultV\":\"\"},\"createTime\":{\"columnName\":\"create_time\",\"propertyName\":\"createTime\",\"javaType\":{\"simpleName\":\"LocalDateTime\",\"qualifier\":\"java.time.LocalDateTime\"},\"description\":\"插入数据的时间\",\"length\":null,\"notnull\":true,\"defaultV\":\"CURRENT_TIMESTAMP\"},\"description\":{\"columnName\":\"description\",\"propertyName\":\"description\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"描述\",\"length\":512,\"notnull\":false,\"defaultV\":null},\"createUserUuid\":{\"columnName\":\"create_user_uuid\",\"propertyName\":\"createUserUuid\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"插入数据时登录者的userUuid。若数据并非登录者插入的，值为-1\",\"length\":36,\"notnull\":true,\"defaultV\":\"\"},\"updateTime\":{\"columnName\":\"update_time\",\"propertyName\":\"updateTime\",\"javaType\":{\"simpleName\":\"LocalDateTime\",\"qualifier\":\"java.time.LocalDateTime\"},\"description\":\"最近一次更新数据的时间。若数据从未更新过，与create_time保持一致\",\"length\":null,\"notnull\":true,\"defaultV\":\"CURRENT_TIMESTAMP\"},\"id\":{\"columnName\":\"id\",\"propertyName\":\"id\",\"javaType\":{\"simpleName\":\"Long\",\"qualifier\":\"java.lang.Long\"},\"description\":\"主键\",\"length\":null,\"notnull\":true,\"defaultV\":null},\"parentId\":{\"columnName\":\"parent_id\",\"propertyName\":\"parentId\",\"javaType\":{\"simpleName\":\"String\",\"qualifier\":\"java.lang.String\"},\"description\":\"上级部门ID\",\"length\":255,\"notnull\":false,\"defaultV\":null}},\"tableName\":\"department\",\"notDeletedSql\":null}";
}
//a2eefe695f481a186579bad01b86c829
