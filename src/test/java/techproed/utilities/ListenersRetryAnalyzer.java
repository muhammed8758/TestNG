package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {
    // Bu Sinifin amaci Tum Fail Test Caseleri Bir Kez Daha Otomatik olarak Run Etmektir
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //Bu sinif ListenersRetry util class ina baglidir.
        annotation.setRetryAnalyzer((ListenersRetry.class));
    }
}