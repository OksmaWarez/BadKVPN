package dev.brighten.antivpn.utils;

public class ReflectionUtils {

    public static <T> T getDeclaredField(Class<?> clazz, String name) throws NoSuchFieldException, IllegalAccessException {
        var declaredField = clazz.getDeclaredField(name);

        declaredField.setAccessible(true);

        return (T) declaredField.get(null);
    }
}
