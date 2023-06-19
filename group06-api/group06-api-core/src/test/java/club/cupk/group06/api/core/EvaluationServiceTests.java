package club.cupk.group06.api.core;

import club.cupk.group06.api.core.service.EvalResultService;
import club.cupk.group06.api.core.service.EvaluationService;
import club.cupk.group06.data.core.domain.Evaluation;
import club.cupk.group06.data.core.dto.indicator.EvalResDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.altitude.cms.common.entity.PageEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluationServiceTests {

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private EvalResultService evalResultService;

    @Test
    /*添加评价方案*/
    public void addTest(){
        List<Evaluation> evaluationList = new ArrayList<>();
        Evaluation evaluation = new Evaluation();
        evaluation.setSchemeId(1L);
        evaluation.setIndicatorId(1L);
        evaluation.setCustWeight(1F);
        evaluationList.add(evaluation);
        evaluationService.addEvaluationList(evaluationList);
    }

    @Test
    /*获取评价方案的具体信息*/
    public void getTest(){
        Evaluation evaluation = new Evaluation();
        evaluation.setSchemeId(1L);
        evaluation.setIndicatorId(1L);
        evaluation.setCustWeight(1F);
        evaluationService.listVo(evaluation);
    }

    @Test
    /*修改评价方案*/
    public void editTest(){
        Evaluation evaluation = new Evaluation();
        evaluation.setSchemeId(1L);
        evaluation.setIndicatorId(2L);
        evaluation.setCustWeight(2F);
        evaluationService.updateById(evaluation);
    }

    @Test
    /*删除评价方案*/
    public void deleteTest(){
        Long[] evalIds = {1L};
        evaluationService.removeByIds(Arrays.asList(evalIds));
    }


    @Test
    /*获取评价结果*/
    public void getResultTest(){
        PageEntity pageEntity = new PageEntity(1L, 10L);
        EvalResDTO evalResDTO = new EvalResDTO();
        evalResDTO.setWellName("keyouyihao");
        evalResDTO.setCurrent(1L);
        evalResDTO.setSchemeId(1L);
        evalResDTO.setYear(2023L);
        evalResultService.getEvaluationResult(pageEntity.toPage(),evalResDTO);
    }
}
