package com.shijw.front.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.util.ListUtils;
import org.apache.commons.lang3.StringUtils;
 
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
 
public class ReadExcelUtils {
    public static <T> List<T> readExcel(File excelFile, Class<T> entityClass) {
        List<T> data = new LinkedList<>();
        EasyExcelFactory.read(excelFile, entityClass, new ReadListener<T>(data::addAll)).sheet().doRead();
        return data;
    }
}
 
class ReadListener<T> extends PageReadListener<T> {
    private List<T> cache = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
    private final Consumer<List<T>> consumer;
 
    public ReadListener(Consumer<List<T>> consumer) {
        super(consumer);
        this.consumer = consumer;
    }
 
    @Override
    public void invoke(T data, AnalysisContext context) {
        // 如果一行Excel数据均为空值，则不装载该行数据
        if (lineNull(data)) {
            return;
        }
        cache.add(data);
        if (cache.size() >= BATCH_COUNT) {
            consumer.accept(cache);
            cache = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }
 
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        if (cache == null || cache.isEmpty()) {
            return;
        }
        consumer.accept(cache);
    }
 
    boolean lineNull(T line) {
        if (line instanceof String) {
            return StringUtils.isEmpty((String) line);
        }
        try {
            Set<Field> fields = Arrays.stream(line.getClass().getDeclaredFields()).filter(f -> f.isAnnotationPresent(ExcelProperty.class)).collect(Collectors.toSet());
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(line) != null) {
                    return false;
                }
            }
            return true;
        } catch (Exception ignored) {
        }
        return true;
    }
 
}