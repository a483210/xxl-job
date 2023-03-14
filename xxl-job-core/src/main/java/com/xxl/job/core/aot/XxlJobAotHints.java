package com.xxl.job.core.aot;

import com.xxl.job.core.biz.model.*;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

/**
 * XxlJobAotHints
 *
 * @author Created by a483210 on 2023/3/13 22:32
 * @since 3.0.0
 */
public class XxlJobAotHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        if (classLoader == null) {
            return;
        }

        MemberCategory[] memberCategories = {MemberCategory.DECLARED_FIELDS,
                MemberCategory.PUBLIC_FIELDS,
                MemberCategory.INVOKE_PUBLIC_METHODS,
                MemberCategory.INVOKE_PUBLIC_CONSTRUCTORS};

        hints.reflection()
                .registerType(ReturnT.class, memberCategories)
                .registerType(LogResult.class, memberCategories)
                .registerType(IdleBeatParam.class, memberCategories)
                .registerType(TriggerParam.class, memberCategories)
                .registerType(KillParam.class, memberCategories)
                .registerType(LogParam.class, memberCategories)
                .registerType(HandleCallbackParam.class, memberCategories)
                .registerType(RegistryParam.class, memberCategories);
    }
}
