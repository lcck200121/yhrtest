package com.yhr;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

public class ActivityDemo {


    //文件上传
    @Test
    public void testDeployment() {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("processes/test.bpmn")//添加bpmn
                .addClasspathResource("processes/test.myLeave.png")//添加png文件
                .name("请假申请流程")
                .deploy();

        System.out.println("部署id：" + deployment.getId());
        System.out.println("部署名称:" + deployment.getName());
    }


    @Test
    /*部署流程方案二,通过zip打包上传,通过名字后面的.来对应。比如上面的.myLeave  会对应bpmn的id myLeave*/
    public void deplay2() {
        /*得到流程引擎的对象*/
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        /*通过流程引擎的对象得到部署的服务层的对象*/
        RepositoryService repositoryService = processEngine.getRepositoryService();
        /*获取当前资源文件的输入流*/
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("process.zip");
        /*zip包输入流*/
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        /*调用部署服务*/
        Deployment deploy = repositoryService.createDeployment()
                .addZipInputStream(zipInputStream)
                .name("请假审批")
                .deploy();
        System.out.println("部署的id" + deploy.getName());
    }

    //启动流程
    @Test
    public void testStartProcess() {
//        1、创aProcessEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();//2、获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
//        3、根据流程定义Id启动流程
        ProcessInstance processInstance = runtimeService
                .startProcessInstanceByKey("myLeave");
//        输出内容
        System.out.println("流程定义id: " + processInstance.getProcessDefinitionId());
        System.out.println("流程实例id: " + processInstance.getId());
        System.out.println("当前活动Id: " + processInstance.getActivityId());

    }

    //查找任务
    @Test
    public void testFindPersonalTaskList(){
        String assignee = "worker";  //bpmn里面设置的worker
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();

        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("myLeave")
                .taskAssignee(assignee)   //只查询该任务负责人的任务
                .list();

        for (Task task : list) {
            System.out.println("流程实例id:" + task.getProcessInstanceId());//整个请假流程的id
            System.out.println("任务id:" + task.getId());  //流程到了请假那个对象的id
            System.out.println("任务负责人:" + task.getAssignee());
            System.out.println("任务名称:"+ task.getName());
        }
    }

//完成任务
    @Test
    public void completTask(){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("myLeave")//流程钥匙
                .taskAssignee("worker")
                .singleResult();
//    完成任务，参数：任务id，这里完成了员工的请假任务后，流程到了需要审批的领导那里了，可以吧Assignee换成leader再完成
        taskService.complete(task.getId());
    }

    @Test
    //查询流程
    public void queryProcessInstance(){
        String processDefinitionKey="myLeave";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        List<ProcessInstance> list=runtimeService.createProcessInstanceQuery()
                .processDefinitionKey(processDefinitionKey)
                .list();

        for(ProcessInstance processInstance : list) {
            System.out.println("流程id"+processInstance.getProcessInstanceId());
            System.out.println("所属流程定义id:"+ processInstance.getProcessDefinitionId());
            System.out.println("是否执行完成:"+ processInstance.isEnded());
            System.out.println("是否暂停:"+ processInstance.isSuspended());
            System.out.println("当前活动标识:"+ processInstance.getActivityId());
            System.out.println("业务关键字"+processInstance.getBusinessKey());
        }
    }

    @Test
    //删除流程
    public void delete(){
        String deploymentId="1";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 通过流程引警获取repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
//        删除流程定义，如果该流程定义已有流程实例启动则删除时出钟
        repositoryService.deleteDeployment(deploymentId);
//        设置true 级联删除流程定义，即使该流程有流程实例启动也可以删除，设置为false 非级别删除方式，
//        如果流程repositoryService.deleteDeployment(deploymentId，true);
    }



}
