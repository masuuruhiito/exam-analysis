//package com.shijw.front.listener;
//
//import com.alibaba.excel.context.AnalysisContext;
//import lombok.extern.slf4j.Slf4j;
//
//import java.util.ArrayList;
//import java.util.Map;
//
//@Slf4j
//public class EasyExcelListener extends AnalysisEventListener<EasyExcelDemo> {
//
//    public static List<EasyExcelDemo> importList = new ArrayList<>();
//    public static final ThreadLocal<Resp> RESP = new ThreadLocal<>();
//
//    @Override
//    public void invoke(EasyExcelDemo data, AnalysisContext context) {
//        log.info("解析到的一条数据: excelRow = {}", data);
//        importList.add(data);
//    }
//
//    @Override
//    public void doAfterAllAnalysed(AnalysisContext context) {
//        // 解析完所有excel行, 保存到数据库或进行业务处理
//        log.info("解析的所有数据 list = {}", importList);
//        Resp resp = new Resp();
//        resp.setImportList(importList);
//        RESP.set(resp);
//    }
//
//    @Override
//    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
//        log.info("表头数据 excelHead= {}", headMap);
//    }
//}