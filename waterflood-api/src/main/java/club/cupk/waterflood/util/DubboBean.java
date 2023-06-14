package club.cupk.waterflood.util;

import org.apache.dubbo.config.spring.ReferenceBean;
import org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor;
import xin.altitude.cms.common.util.SpringUtils;

import java.util.Collection;

public class DubboBean {
    public static <T> T getDubboBean(Class<T> requiredType){
        ReferenceAnnotationBeanPostProcessor dubboContext = SpringUtils.getBean(ReferenceAnnotationBeanPostProcessor.class);
        Collection<ReferenceBean<?>> referenceBeans = dubboContext.getReferenceBeans();
        for (ReferenceBean<?> referenceBean : referenceBeans) {
            Class<?> objectType = referenceBean.getObjectType();
            if(objectType == requiredType){
                return (T)referenceBean.getObject();
            }
        }
        return null;
    }
}
