package com.xxl.job.admin.aot;

import com.xxl.job.admin.core.model.*;
import com.xxl.job.admin.core.route.ExecutorRouteStrategyEnum;
import com.xxl.job.admin.core.scheduler.MisfireStrategyEnum;
import com.xxl.job.admin.core.scheduler.ScheduleTypeEnum;
import com.xxl.job.admin.core.util.I18nUtil;
import com.xxl.job.core.enums.ExecutorBlockStrategyEnum;
import com.xxl.job.core.glue.GlueTypeEnum;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.RequestContext;

import java.lang.reflect.Method;

/**
 * AotHints
 *
 * @author Created by a483210 on 2025/01/02 13:06
 * @since 1.0.0
 */
public class AdminAotHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
        if (classLoader == null) {
            return;
        }

        hints.resources().registerPattern("i18n/**")
                .registerPattern("mybatis-mapper/*.xml")
                .registerPattern("static/**")
                .registerPattern("templates/**");

        MemberCategory[] memberCategories = {MemberCategory.DECLARED_FIELDS,
                MemberCategory.PUBLIC_FIELDS,
                MemberCategory.INVOKE_PUBLIC_METHODS,
                MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS};

        hints.reflection()
                .registerType(HikariConfig.class, memberCategories)

                .registerType(XxlJobGroup.class, memberCategories)
                .registerType(XxlJobInfo.class, memberCategories)
                .registerType(XxlJobLog.class, memberCategories)
                .registerType(XxlJobLogGlue.class, memberCategories)
                .registerType(XxlJobLogReport.class, memberCategories)
                .registerType(XxlJobRegistry.class, memberCategories)
                .registerType(XxlJobUser.class, memberCategories)

                .registerType(I18nUtil.class, memberCategories)

                .registerType(ExecutorBlockStrategyEnum.class, memberCategories)
                .registerType(MisfireStrategyEnum.class, memberCategories)
                .registerType(ExecutorRouteStrategyEnum.class, memberCategories)
                .registerType(ScheduleTypeEnum.class, memberCategories)
                .registerType(GlueTypeEnum.class, memberCategories);

        try {
            Method contextPathMethod = RequestContext.class.getMethod("getContextPath");

            hints.reflection().registerMethod(contextPathMethod, ExecutableMode.INVOKE);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }
}
