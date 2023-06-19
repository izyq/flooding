package club.cupk.group06.api.core;

import club.cupk.group06.api.core.service.RecordService;
import club.cupk.group06.common.web.response.AjaxResult;
import club.cupk.group06.data.core.domain.Record;
import club.cupk.group06.data.core.domain.Well;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.altitude.cms.common.entity.PageEntity;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordServiceTests {

    @Resource
    RecordService recordService;

    @Test
    /*添加指标数据*/
    public void add(){
        List<Record> records = new ArrayList<>();
        Record record = new Record();
        record.setWellId(1L);
        record.setIndicatorId(1L);
        record.setRecordValue(1.0F);
        record.setRecordTime(LocalDateTime.now());
        records.add(record);
        recordService.saveBatch(records);
    }

    @Test
    /*删除指标数据*/
    public void delete(){
        Long[] recordIds = {68L};
        recordService.removeByIds(Arrays.asList(recordIds));
    }

    @Test
    /*分页*/
    public void page(){
        PageEntity pageEntity = new PageEntity(1L, 10L);
        Record record = new Record();
        record.setWellId(1L);
        record.setIndicatorId(1L);
        record.setRecordValue(1.0F);
        record.setRecordTime(LocalDateTime.now());
        recordService.getPage(pageEntity.toPage(), record);
    }

    @Test
    /*通过井id获取数据*/
    public void listByWellId(){
        Well well = new Well();
        well.setWellId(1L);
        recordService.listVo(well);
    }
}
