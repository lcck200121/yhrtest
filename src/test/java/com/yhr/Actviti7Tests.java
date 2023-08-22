package com.yhr;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.runtime.TaskRuntime;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Actviti7Tests {
    @Autowired
    private ProcessRuntime processRuntime;//
    @Autowired
    private TaskRuntime taskRuntime;
    @Autowired
    private SecurityUtil securityUtil;
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 查看流程定义
     */
    @Test
    public void Test1() {
        securityUtil.logInAs("system");
        Page<ProcessDefinition> processDefinitionPage =
                processRuntime.processDefinitions(Pageable.of(0, 10));
        System.out.println("可用的流程定义数量：" + processDefinitionPage.getTotalItems());
        for (org.activiti.api.process.model.ProcessDefinition pd : processDefinitionPage.getContent()) {
            System.out.println("流程定义：" + pd);
        }
    }

    @Test
    public void test2(){
        ProcessInstance myLeave = runtimeService.startProcessInstanceByKey("myLeave");
        System.out.println(myLeave.getId());
    }


    /**
     * 启动流程实例
     */
//    @Test
////    public void Test2() {
////        securityUtil.logInAs("system");
////        ProcessInstance pi = processRuntime.start(ProcessPayloadBuilder.
////                start().
////                withProcessDefinitionKey("myProcess").
////                build());
////        System.out.println("流程实例ID：" + pi.getId());
////    }


    /**
     **查询任务，并完成自己的任务
     **/
//    @Test
//    public void Test3() {
//        securityUtil.logInAs("jack");
//        Page<Task> taskPage=taskRuntime.tasks(Pageable.of(0,10));
//        if (taskPage.getTotalItems()>0){
//            for (Task task:taskPage.getContent()){
//                // 拾取任务
//                taskRuntime.claim(TaskPayloadBuilder.
//                        claim().
//                        withTaskId(task.getId()).build());
//                // 完成任务
//                taskRuntime.complete(TaskPayloadBuilder.
//                        complete().
//                        withTaskId(task.getId()).build());
//            }
//        }
//    }
}
