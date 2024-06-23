package com.spldeolin.satisficing.security.client.annotation;

/**
 * @author Deolin 2024-06-20
 */
public @interface AccessControl {

    /**
     * 认证方式
     */
    Type value() default Type.IS_AUTHENTICATED;

    /**
     * 权限名称
     *
     * 若value=IS_AUTHORIZED，注解所声明的请求方法将会在启动时上报为1条permission数据，可通过该属性指定权限的名称
     */
    String permissionName() default "";

    enum Type {

        /**
         * 不进行认证、鉴权和访问控制
         */
        SKIP,

        /**
         * 允许任何请求访问
         */
        PERMIT_ALL,

        /**
         * 必须经过登录认证才可访问
         */
        IS_AUTHENTICATED,

        /**
         * 必须经过登录认证并且被授权才可访问
         */
        IS_AUTHORIZED,
    }

}
