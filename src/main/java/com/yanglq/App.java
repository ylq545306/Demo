package com.yanglq;

import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.cdi.KContainer;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

/**
 * Hello world!
 */
public class App {
    @KContainer
    static
    KieContainer kieContainer;
    public static void main(String[] args) throws Exception {
        ReleaseIdImpl releaseId = new ReleaseIdImpl("com.yanglq", "droolsTest", "LATEST");
        KieServices ks = KieServices.Factory.get();
        KieContainer container = ks.newKieContainer(releaseId);
        KieScanner scanner = ks.newKieScanner(kieContainer);
        scanner.start(1000);
        StatelessKieSession session = container.newStatelessKieSession();

//        for (int i = 0; i < 100; i++) {
////            FactType factType = factType(container.getKieBase());
////            Object applicant = makeApplicant(factType);
//            Applicant applicant = new Applicant();
//            applicant.setName("东方闪电");
//            applicant.setAge(17);
//            session.execute(applicant);
//            System.out.println("申请人：" + applicant.getName() + "，年龄：" + applicant.getAge() + "是否可以申请驾照" + applicant.getValid());
//
//            Thread.sleep(2000);//休眠20秒，等待更新规则查看输出结果
//        }
    }

//    private static Object makeApplicant(FactType factType) throws Exception {
//        Object applicant = factType.newInstance();
//        factType.set(applicant, "name", "张三");
//        factType.set(applicant, "age", 17);
//        return applicant;
//    }
//
//    protected static FactType factType(KieBase base) {
//        FactType factType = base.getFactType("com.yanglq", "Applicant");
//        return factType;
//    }
}