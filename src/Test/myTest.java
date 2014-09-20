package Test;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
import pj.parser.ast.visitor.DummyClassToDetermineVariableType;//#GEN#[-1]#PJ#
import pj.Pyjama;//#GEN#[-1]#PJ#
import Uni.*;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
import pj.pr.*;//#GEN#[-1]#PJ#
import pj.PjRuntime;//#GEN#[-1]#PJ#
import java.util.concurrent.*;//#GEN#[-1]#PJ#
import java.util.concurrent.atomic.AtomicInteger;//#GEN#[-1]#PJ#
import java.util.concurrent.locks.ReentrantLock;//#GEN#[-1]#PJ#
import javax.swing.SwingUtilities;//#GEN#[-1]#PJ#
import java.lang.reflect.InvocationTargetException;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
public class myTest {//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    public static void main(String[] args) {{//#GEN#[-1]#PJ#
        myTest t = new myTest();//#GEN#[-1]#PJ#
        t.ParallelWithoutCritical();//#GEN#[-1]#PJ#
        t.ParallelWithCritical();//#GEN#[-1]#PJ#
        t.Sequential();//#GEN#[-1]#PJ#
        t.ParallelUniversal();//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    //Pyjama runtime shutdown at the end of main method
    PjRuntime.shutdown();
    }//#GEN#[-1]#PJ#
    //#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    public static void ParallelWithoutCritical() {{//#GEN#[-1]#PJ#
        Tester myCounter = new Tester();//#GEN#[-1]#PJ#
        Pyjama.omp_set_num_threads(4);//#GEN#[-1]#PJ#
        double start_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#0) -- START *///#GEN#[-1]#PJ#
        InternalControlVariables icv_previous__OMP_ParallelRegion_0 = PjRuntime.getCurrentThreadICV();//#GEN#[-1]#PJ#
        InternalControlVariables icv__OMP_ParallelRegion_0 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        int _threadNum__OMP_ParallelRegion_0 = icv__OMP_ParallelRegion_0.nthreads_var.get(icv__OMP_ParallelRegion_0.levels_var);//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        inputlist__OMP_ParallelRegion_0.put("myCounter",myCounter);
        _OMP_ParallelRegion_0 _OMP_ParallelRegion_0_in = new _OMP_ParallelRegion_0(_threadNum__OMP_ParallelRegion_0,icv__OMP_ParallelRegion_0,inputlist__OMP_ParallelRegion_0,outputlist__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        _OMP_ParallelRegion_0_in.runParallelCode();//#GEN#[-1]#PJ#
        myCounter = (Tester)outputlist__OMP_ParallelRegion_0.get("myCounter");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#0) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
        double end_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        System.out.print("Parallel Without Critical Result:");//#GEN#[-1]#PJ#
        System.out.print(myCounter.get());//#GEN#[-1]#PJ#
        System.out.println("(Time spent is:" + (end_time - start_time) + ")");//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    }
static class _OMP_ParallelRegion_0{
        private int OMP_threadNumber = 1;
        private InternalControlVariables icv;
        private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
        private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
        private CyclicBarrier OMP_barrier;
        private ReentrantLock OMP_lock;

        //#BEGIN shared variables defined here
        Tester myCounter = null;
        //#END shared variables defined here
        public _OMP_ParallelRegion_0(int thread_num, InternalControlVariables icv, ConcurrentHashMap<String, Object> inputlist, ConcurrentHashMap<String, Object> outputlist) {
            this.icv = icv;
            if ((false == Pyjama.omp_get_nested()) && (Pyjama.omp_get_level() > 0)) {
                this.OMP_threadNumber = 1;
            }else {
                this.OMP_threadNumber = thread_num;
            }
            icv.currentParallelRegionThreadNumber = this.OMP_threadNumber;
            this.OMP_inputList = inputlist;
            this.OMP_outputList = outputlist;
            this.OMP_barrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_CurrentParallelRegionBarrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_orderCursor = new AtomicInteger(0);
            //#BEGIN shared variables initialised here
            myCounter = (Tester)OMP_inputList.get("myCounter");
            //#END shared variables initialised here
        }

        private void updateOutputListForSharedVars() {
            //BEGIN update outputlist
            OMP_outputList.put("myCounter",myCounter);
            //END update outputlist
        }
        class MyCallable implements Callable<ConcurrentHashMap<String,Object>> {
            private int alias_id;
            private ConcurrentHashMap<String, Object> OMP_inputList;
            private ConcurrentHashMap<String, Object> OMP_outputList;
            //#BEGIN firstprivate reduction variables defined here
            //#END firstprivate reduction variables  defined here
            void setBarrier() {
                try {OMP_barrier.await();}
                catch (InterruptedException e) {e.printStackTrace();}
                catch (BrokenBarrierException e) {e.printStackTrace();}
            }
            MyCallable(int id, ConcurrentHashMap<String,Object> inputlist, ConcurrentHashMap<String,Object> outputlist){
                this.alias_id = id;
                this.OMP_inputList = inputlist;
                this.OMP_outputList = outputlist;
                //#BEGIN firstprivate reduction variables initialised here
                //#END firstprivate reduction variables initialised here
            }

            @Override
            public ConcurrentHashMap<String,Object> call() {
                InternalControlVariables currentThreadICV = new InternalControlVariables(icv);
                currentThreadICV.currentThreadAliasID = this.alias_id;
                PjRuntime.setCurrentThreadICV(currentThreadICV);

                
                /****User Code BEGIN***/
                {//#GEN#[-1]#PJ#
                    /*OpenMP Work Share region (#0) -- START *///#GEN#[-1]#PJ#
                    ConcurrentHashMap<String, Object> _OMP_WorkShare_0_OMP_inputList = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
                    ConcurrentHashMap<String, Object> _OMP_WorkShare_0_OMP_outputList = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
                    _OMP_WorkShare_0_OMP_inputList.put("myCounter",myCounter);
                    PjRuntime.setBarrier();//#GEN#[-1]#PJ#
                    _OMP_WorkShare_0(_OMP_WorkShare_0_OMP_inputList,_OMP_WorkShare_0_OMP_outputList);//#GEN#[-1]#PJ#
                    /*OpenMP Work Share region (#0) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
                }
                /****User Code END***/
                //BEGIN reduction procedure
                //END reduction procedure
                setBarrier();
                if (0 == this.alias_id) {
                    updateOutputListForSharedVars();
                }
                return null;
            }
        }
        public void runParallelCode() {
            for (int i = 1; i <= this.OMP_threadNumber-1; i++) {
                Callable<ConcurrentHashMap<String,Object>> slaveThread = new MyCallable(i, OMP_inputList, OMP_outputList);
                PjRuntime.submit(slaveThread);
            }
            Callable<ConcurrentHashMap<String,Object>> masterThread = new MyCallable(0, OMP_inputList, OMP_outputList);
            try {
                masterThread.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    
private static void _OMP_WorkShare_0(ConcurrentHashMap<String, Object> OMP_inputList, ConcurrentHashMap<String, Object> OMP_outputList) {
    //#BEGIN firstprivate lastprivate reduction variables defined and initialized here
    //#END firstprivate lastprivate reduction variables defined and initialized here
    //#BEGIN shared variables variables defined and initialized here
    Tester myCounter = null;
    myCounter = (Tester)OMP_inputList.get("myCounter");
    //#END shared variables defined and initialized here
    int OMP_iterator = 0;
    int _omp_i_0;
    int OMP_end = (int)((4)-(0))/(1);
    if (((4)-(0))%(1) == 0) {
        OMP_end = OMP_end - 1;
    }
    if (0 == Pyjama.omp_get_thread_num()) {
        PjRuntime.get_OMP_loopCursor().getAndSet(0);}
    PjRuntime.setBarrier();
    while ((OMP_iterator = PjRuntime.get_OMP_loopCursor().getAndAdd(1)) <= OMP_end) {
        for (int OMP_local_iterator = OMP_iterator; OMP_local_iterator<OMP_iterator+1 && OMP_local_iterator<=OMP_end; OMP_local_iterator++){
            _omp_i_0 = 0 + OMP_local_iterator * (1);
            {//#GEN#[-1]#PJ#
                switch(_omp_i_0) {//#GEN#[-1]#PJ#
                    case 0://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    myCounter.inc();//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    myCounter.dec();//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                    case 1://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    myCounter.inc();//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    myCounter.dec();//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                    case 2://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    myCounter.inc();//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    myCounter.dec();//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                    case 3://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    myCounter.inc();//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    myCounter.dec();//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                }//#GEN#[-1]#PJ#
            }if (OMP_end == OMP_local_iterator) {
                //BEGIN lastprivate variables value set
                //END lastprivate variables value set
            }

        }
    }
    //BEGIN shared, reduction, lastprivate, update outputlist
    //END shared,reduction, lastprivate, update outputlist
    PjRuntime.setBarrier();
}
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    public static void Sequential() {{//#GEN#[-1]#PJ#
        Tester myCounter = new Tester();//#GEN#[-1]#PJ#
        Pyjama.omp_set_num_threads(4);//#GEN#[-1]#PJ#
        double start_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
            if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                myCounter.inc();//#GEN#[-1]#PJ#
            } else {//#GEN#[-1]#PJ#
                myCounter.dec();//#GEN#[-1]#PJ#
            }//#GEN#[-1]#PJ#
        }//#GEN#[-1]#PJ#
        for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
            if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                myCounter.inc();//#GEN#[-1]#PJ#
            } else {//#GEN#[-1]#PJ#
                myCounter.dec();//#GEN#[-1]#PJ#
            }//#GEN#[-1]#PJ#
        }//#GEN#[-1]#PJ#
        for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
            if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                myCounter.inc();//#GEN#[-1]#PJ#
            } else {//#GEN#[-1]#PJ#
                myCounter.dec();//#GEN#[-1]#PJ#
            }//#GEN#[-1]#PJ#
        }//#GEN#[-1]#PJ#
        for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
            if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                myCounter.inc();//#GEN#[-1]#PJ#
            } else {//#GEN#[-1]#PJ#
                myCounter.dec();//#GEN#[-1]#PJ#
            }//#GEN#[-1]#PJ#
        }//#GEN#[-1]#PJ#
        double end_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        System.out.print("Sequential Result:");//#GEN#[-1]#PJ#
        System.out.print(myCounter.get());//#GEN#[-1]#PJ#
        System.out.println("(Time spent is:" + (end_time - start_time) + ")");//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    //#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    public static void ParallelWithCritical() {{//#GEN#[-1]#PJ#
        Tester myCounter = new Tester();//#GEN#[-1]#PJ#
        Pyjama.omp_set_num_threads(4);//#GEN#[-1]#PJ#
        double start_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#1) -- START *///#GEN#[-1]#PJ#
        InternalControlVariables icv_previous__OMP_ParallelRegion_1 = PjRuntime.getCurrentThreadICV();//#GEN#[-1]#PJ#
        InternalControlVariables icv__OMP_ParallelRegion_1 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_1);//#GEN#[-1]#PJ#
        int _threadNum__OMP_ParallelRegion_1 = icv__OMP_ParallelRegion_1.nthreads_var.get(icv__OMP_ParallelRegion_1.levels_var);//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_1 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_1 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        inputlist__OMP_ParallelRegion_1.put("myCounter",myCounter);
        _OMP_ParallelRegion_1 _OMP_ParallelRegion_1_in = new _OMP_ParallelRegion_1(_threadNum__OMP_ParallelRegion_1,icv__OMP_ParallelRegion_1,inputlist__OMP_ParallelRegion_1,outputlist__OMP_ParallelRegion_1);//#GEN#[-1]#PJ#
        _OMP_ParallelRegion_1_in.runParallelCode();//#GEN#[-1]#PJ#
        myCounter = (Tester)outputlist__OMP_ParallelRegion_1.get("myCounter");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_1);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#1) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
        double end_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        System.out.print("Parallel Critical Result:");//#GEN#[-1]#PJ#
        System.out.print(myCounter.get());//#GEN#[-1]#PJ#
        System.out.println("(Time spent is:" + (end_time - start_time) + ")");//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    }
static class _OMP_ParallelRegion_1{
        private int OMP_threadNumber = 1;
        private InternalControlVariables icv;
        private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
        private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
        private CyclicBarrier OMP_barrier;
        private ReentrantLock OMP_lock;

        //#BEGIN shared variables defined here
        Tester myCounter = null;
        //#END shared variables defined here
        public _OMP_ParallelRegion_1(int thread_num, InternalControlVariables icv, ConcurrentHashMap<String, Object> inputlist, ConcurrentHashMap<String, Object> outputlist) {
            this.icv = icv;
            if ((false == Pyjama.omp_get_nested()) && (Pyjama.omp_get_level() > 0)) {
                this.OMP_threadNumber = 1;
            }else {
                this.OMP_threadNumber = thread_num;
            }
            icv.currentParallelRegionThreadNumber = this.OMP_threadNumber;
            this.OMP_inputList = inputlist;
            this.OMP_outputList = outputlist;
            this.OMP_barrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_CurrentParallelRegionBarrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_orderCursor = new AtomicInteger(0);
            //#BEGIN shared variables initialised here
            myCounter = (Tester)OMP_inputList.get("myCounter");
            //#END shared variables initialised here
        }

        private void updateOutputListForSharedVars() {
            //BEGIN update outputlist
            OMP_outputList.put("myCounter",myCounter);
            //END update outputlist
        }
        class MyCallable implements Callable<ConcurrentHashMap<String,Object>> {
            private int alias_id;
            private ConcurrentHashMap<String, Object> OMP_inputList;
            private ConcurrentHashMap<String, Object> OMP_outputList;
            //#BEGIN firstprivate reduction variables defined here
            //#END firstprivate reduction variables  defined here
            void setBarrier() {
                try {OMP_barrier.await();}
                catch (InterruptedException e) {e.printStackTrace();}
                catch (BrokenBarrierException e) {e.printStackTrace();}
            }
            MyCallable(int id, ConcurrentHashMap<String,Object> inputlist, ConcurrentHashMap<String,Object> outputlist){
                this.alias_id = id;
                this.OMP_inputList = inputlist;
                this.OMP_outputList = outputlist;
                //#BEGIN firstprivate reduction variables initialised here
                //#END firstprivate reduction variables initialised here
            }

            @Override
            public ConcurrentHashMap<String,Object> call() {
                InternalControlVariables currentThreadICV = new InternalControlVariables(icv);
                currentThreadICV.currentThreadAliasID = this.alias_id;
                PjRuntime.setCurrentThreadICV(currentThreadICV);

                
                /****User Code BEGIN***/
                {//#GEN#[-1]#PJ#
                    /*OpenMP Work Share region (#1) -- START *///#GEN#[-1]#PJ#
                    ConcurrentHashMap<String, Object> _OMP_WorkShare_1_OMP_inputList = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
                    ConcurrentHashMap<String, Object> _OMP_WorkShare_1_OMP_outputList = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
                    _OMP_WorkShare_1_OMP_inputList.put("myCounter",myCounter);
                    PjRuntime.setBarrier();//#GEN#[-1]#PJ#
                    _OMP_WorkShare_1(_OMP_WorkShare_1_OMP_inputList,_OMP_WorkShare_1_OMP_outputList);//#GEN#[-1]#PJ#
                    /*OpenMP Work Share region (#1) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
                }
                /****User Code END***/
                //BEGIN reduction procedure
                //END reduction procedure
                setBarrier();
                if (0 == this.alias_id) {
                    updateOutputListForSharedVars();
                }
                return null;
            }
        }
        public void runParallelCode() {
            for (int i = 1; i <= this.OMP_threadNumber-1; i++) {
                Callable<ConcurrentHashMap<String,Object>> slaveThread = new MyCallable(i, OMP_inputList, OMP_outputList);
                PjRuntime.submit(slaveThread);
            }
            Callable<ConcurrentHashMap<String,Object>> masterThread = new MyCallable(0, OMP_inputList, OMP_outputList);
            try {
                masterThread.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    
private static void _OMP_WorkShare_1(ConcurrentHashMap<String, Object> OMP_inputList, ConcurrentHashMap<String, Object> OMP_outputList) {
    //#BEGIN firstprivate lastprivate reduction variables defined and initialized here
    //#END firstprivate lastprivate reduction variables defined and initialized here
    //#BEGIN shared variables variables defined and initialized here
    Tester myCounter = null;
    myCounter = (Tester)OMP_inputList.get("myCounter");
    //#END shared variables defined and initialized here
    int OMP_iterator = 0;
    int _omp_i_1;
    int OMP_end = (int)((4)-(0))/(1);
    if (((4)-(0))%(1) == 0) {
        OMP_end = OMP_end - 1;
    }
    if (0 == Pyjama.omp_get_thread_num()) {
        PjRuntime.get_OMP_loopCursor().getAndSet(0);}
    PjRuntime.setBarrier();
    while ((OMP_iterator = PjRuntime.get_OMP_loopCursor().getAndAdd(1)) <= OMP_end) {
        for (int OMP_local_iterator = OMP_iterator; OMP_local_iterator<OMP_iterator+1 && OMP_local_iterator<=OMP_end; OMP_local_iterator++){
            _omp_i_1 = 0 + OMP_local_iterator * (1);
            {//#GEN#[-1]#PJ#
                switch(_omp_i_1) {//#GEN#[-1]#PJ#
                    case 0://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                PjRuntime.OMP_lock.lock();//#GEN#[-1]#PJ#
                                try {//#GEN#[-1]#PJ#
                                    {//#GEN#[-1]#PJ#
                                        if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                            myCounter.inc();//#GEN#[-1]#PJ#
                                        } else {//#GEN#[-1]#PJ#
                                            myCounter.dec();//#GEN#[-1]#PJ#
                                        }//#GEN#[-1]#PJ#
                                    }} finally {//#GEN#[-1]#PJ#
                                PjRuntime.OMP_lock.unlock();//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                    }//#GEN#[-1]#PJ#
                    break;//#GEN#[-1]#PJ#
                case 1://#GEN#[-1]#PJ#
                    {//#GEN#[-1]#PJ#
                        for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                            PjRuntime.OMP_lock.lock();//#GEN#[-1]#PJ#
                            try {//#GEN#[-1]#PJ#
                                {//#GEN#[-1]#PJ#
                                    if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                        myCounter.inc();//#GEN#[-1]#PJ#
                                    } else {//#GEN#[-1]#PJ#
                                        myCounter.dec();//#GEN#[-1]#PJ#
                                    }//#GEN#[-1]#PJ#
                                }} finally {//#GEN#[-1]#PJ#
                            PjRuntime.OMP_lock.unlock();//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
                    }//#GEN#[-1]#PJ#
                }//#GEN#[-1]#PJ#
                break;//#GEN#[-1]#PJ#
            case 2://#GEN#[-1]#PJ#
                {//#GEN#[-1]#PJ#
                    for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                        PjRuntime.OMP_lock.lock();//#GEN#[-1]#PJ#
                        try {//#GEN#[-1]#PJ#
                            {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    myCounter.inc();//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    myCounter.dec();//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }} finally {//#GEN#[-1]#PJ#
                        PjRuntime.OMP_lock.unlock();//#GEN#[-1]#PJ#
                    }//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
                }//#GEN#[-1]#PJ#
            }//#GEN#[-1]#PJ#
            break;//#GEN#[-1]#PJ#
        case 3://#GEN#[-1]#PJ#
            {//#GEN#[-1]#PJ#
                for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                    PjRuntime.OMP_lock.lock();//#GEN#[-1]#PJ#
                    try {//#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                myCounter.inc();//#GEN#[-1]#PJ#
                            } else {//#GEN#[-1]#PJ#
                                myCounter.dec();//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }} finally {//#GEN#[-1]#PJ#
                    PjRuntime.OMP_lock.unlock();//#GEN#[-1]#PJ#
                }//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
            }//#GEN#[-1]#PJ#
        }//#GEN#[-1]#PJ#
        break;//#GEN#[-1]#PJ#
}//#GEN#[-1]#PJ#
}if (OMP_end == OMP_local_iterator) {
//BEGIN lastprivate variables value set
//END lastprivate variables value set
}

}
}
//BEGIN shared, reduction, lastprivate, update outputlist
//END shared,reduction, lastprivate, update outputlist
PjRuntime.setBarrier();
}
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    public static void ParallelUniversal() {{//#GEN#[-1]#PJ#
        Tester myCounter = new Tester();//#GEN#[-1]#PJ#
        Pyjama.omp_set_num_threads(4);//#GEN#[-1]#PJ#
        double start_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        LockFreeUniversal lf = new LockFreeUniversal(4, myCounter);//#GEN#[-1]#PJ#
        Invocation inc_lf = new Invocation(11);//#GEN#[-1]#PJ#
        Invocation dec_lf = new Invocation(22);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#2) -- START *///#GEN#[-1]#PJ#
        InternalControlVariables icv_previous__OMP_ParallelRegion_2 = PjRuntime.getCurrentThreadICV();//#GEN#[-1]#PJ#
        InternalControlVariables icv__OMP_ParallelRegion_2 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_2);//#GEN#[-1]#PJ#
        int _threadNum__OMP_ParallelRegion_2 = icv__OMP_ParallelRegion_2.nthreads_var.get(icv__OMP_ParallelRegion_2.levels_var);//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_2 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_2 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        inputlist__OMP_ParallelRegion_2.put("lf",lf);
        inputlist__OMP_ParallelRegion_2.put("inc_lf",inc_lf);
        inputlist__OMP_ParallelRegion_2.put("dec_lf",dec_lf);
        _OMP_ParallelRegion_2 _OMP_ParallelRegion_2_in = new _OMP_ParallelRegion_2(_threadNum__OMP_ParallelRegion_2,icv__OMP_ParallelRegion_2,inputlist__OMP_ParallelRegion_2,outputlist__OMP_ParallelRegion_2);//#GEN#[-1]#PJ#
        _OMP_ParallelRegion_2_in.runParallelCode();//#GEN#[-1]#PJ#
        lf = (LockFreeUniversal)outputlist__OMP_ParallelRegion_2.get("lf");
        inc_lf = (Invocation)outputlist__OMP_ParallelRegion_2.get("inc_lf");
        dec_lf = (Invocation)outputlist__OMP_ParallelRegion_2.get("dec_lf");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_2);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#2) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
        double end_time = Pyjama.omp_get_wtick();//#GEN#[-1]#PJ#
        System.out.print("Parallel Univeral Result:");//#GEN#[-1]#PJ#
        System.out.print(((Tester) (lf.fetchObj())).get());//#GEN#[-1]#PJ#
        System.out.println("(Time spent is:" + (end_time - start_time) + ")");//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    }
static class _OMP_ParallelRegion_2{
        private int OMP_threadNumber = 1;
        private InternalControlVariables icv;
        private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
        private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
        private CyclicBarrier OMP_barrier;
        private ReentrantLock OMP_lock;

        //#BEGIN shared variables defined here
        LockFreeUniversal lf = null;
        Invocation inc_lf = null;
        Invocation dec_lf = null;
        //#END shared variables defined here
        public _OMP_ParallelRegion_2(int thread_num, InternalControlVariables icv, ConcurrentHashMap<String, Object> inputlist, ConcurrentHashMap<String, Object> outputlist) {
            this.icv = icv;
            if ((false == Pyjama.omp_get_nested()) && (Pyjama.omp_get_level() > 0)) {
                this.OMP_threadNumber = 1;
            }else {
                this.OMP_threadNumber = thread_num;
            }
            icv.currentParallelRegionThreadNumber = this.OMP_threadNumber;
            this.OMP_inputList = inputlist;
            this.OMP_outputList = outputlist;
            this.OMP_barrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_CurrentParallelRegionBarrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_orderCursor = new AtomicInteger(0);
            //#BEGIN shared variables initialised here
            lf = (LockFreeUniversal)OMP_inputList.get("lf");
            inc_lf = (Invocation)OMP_inputList.get("inc_lf");
            dec_lf = (Invocation)OMP_inputList.get("dec_lf");
            //#END shared variables initialised here
        }

        private void updateOutputListForSharedVars() {
            //BEGIN update outputlist
            OMP_outputList.put("lf",lf);
            OMP_outputList.put("inc_lf",inc_lf);
            OMP_outputList.put("dec_lf",dec_lf);
            //END update outputlist
        }
        class MyCallable implements Callable<ConcurrentHashMap<String,Object>> {
            private int alias_id;
            private ConcurrentHashMap<String, Object> OMP_inputList;
            private ConcurrentHashMap<String, Object> OMP_outputList;
            //#BEGIN firstprivate reduction variables defined here
            //#END firstprivate reduction variables  defined here
            void setBarrier() {
                try {OMP_barrier.await();}
                catch (InterruptedException e) {e.printStackTrace();}
                catch (BrokenBarrierException e) {e.printStackTrace();}
            }
            MyCallable(int id, ConcurrentHashMap<String,Object> inputlist, ConcurrentHashMap<String,Object> outputlist){
                this.alias_id = id;
                this.OMP_inputList = inputlist;
                this.OMP_outputList = outputlist;
                //#BEGIN firstprivate reduction variables initialised here
                //#END firstprivate reduction variables initialised here
            }

            @Override
            public ConcurrentHashMap<String,Object> call() {
                InternalControlVariables currentThreadICV = new InternalControlVariables(icv);
                currentThreadICV.currentThreadAliasID = this.alias_id;
                PjRuntime.setCurrentThreadICV(currentThreadICV);

                
                /****User Code BEGIN***/
                {//#GEN#[-1]#PJ#
                    /*OpenMP Work Share region (#2) -- START *///#GEN#[-1]#PJ#
                    ConcurrentHashMap<String, Object> _OMP_WorkShare_2_OMP_inputList = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
                    ConcurrentHashMap<String, Object> _OMP_WorkShare_2_OMP_outputList = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
                    _OMP_WorkShare_2_OMP_inputList.put("lf",lf);
                    _OMP_WorkShare_2_OMP_inputList.put("inc_lf",inc_lf);
                    _OMP_WorkShare_2_OMP_inputList.put("dec_lf",dec_lf);
                    PjRuntime.setBarrier();//#GEN#[-1]#PJ#
                    _OMP_WorkShare_2(_OMP_WorkShare_2_OMP_inputList,_OMP_WorkShare_2_OMP_outputList);//#GEN#[-1]#PJ#
                    /*OpenMP Work Share region (#2) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
                }
                /****User Code END***/
                //BEGIN reduction procedure
                //END reduction procedure
                setBarrier();
                if (0 == this.alias_id) {
                    updateOutputListForSharedVars();
                }
                return null;
            }
        }
        public void runParallelCode() {
            for (int i = 1; i <= this.OMP_threadNumber-1; i++) {
                Callable<ConcurrentHashMap<String,Object>> slaveThread = new MyCallable(i, OMP_inputList, OMP_outputList);
                PjRuntime.submit(slaveThread);
            }
            Callable<ConcurrentHashMap<String,Object>> masterThread = new MyCallable(0, OMP_inputList, OMP_outputList);
            try {
                masterThread.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    
private static void _OMP_WorkShare_2(ConcurrentHashMap<String, Object> OMP_inputList, ConcurrentHashMap<String, Object> OMP_outputList) {
    //#BEGIN firstprivate lastprivate reduction variables defined and initialized here
    //#END firstprivate lastprivate reduction variables defined and initialized here
    //#BEGIN shared variables variables defined and initialized here
    LockFreeUniversal lf = null;
    Invocation inc_lf = null;
    Invocation dec_lf = null;
    lf = (LockFreeUniversal)OMP_inputList.get("lf");
    inc_lf = (Invocation)OMP_inputList.get("inc_lf");
    dec_lf = (Invocation)OMP_inputList.get("dec_lf");
    //#END shared variables defined and initialized here
    int OMP_iterator = 0;
    int _omp_i_6;
    int OMP_end = (int)((4)-(0))/(1);
    if (((4)-(0))%(1) == 0) {
        OMP_end = OMP_end - 1;
    }
    if (0 == Pyjama.omp_get_thread_num()) {
        PjRuntime.get_OMP_loopCursor().getAndSet(0);}
    PjRuntime.setBarrier();
    while ((OMP_iterator = PjRuntime.get_OMP_loopCursor().getAndAdd(1)) <= OMP_end) {
        for (int OMP_local_iterator = OMP_iterator; OMP_local_iterator<OMP_iterator+1 && OMP_local_iterator<=OMP_end; OMP_local_iterator++){
            _omp_i_6 = 0 + OMP_local_iterator * (1);
            {//#GEN#[-1]#PJ#
                switch(_omp_i_6) {//#GEN#[-1]#PJ#
                    case 0://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    lf.apply(inc_lf);//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    lf.apply(dec_lf);//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                    case 1://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    lf.apply(inc_lf);//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    lf.apply(dec_lf);//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                    case 2://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    lf.apply(inc_lf);//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    lf.apply(dec_lf);//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                    case 3://#GEN#[-1]#PJ#
                        {//#GEN#[-1]#PJ#
                            for (int i = 0; i < 10000; i++) {//#GEN#[-1]#PJ#
                                if (0 == (i % 2)) {//#GEN#[-1]#PJ#
                                    lf.apply(inc_lf);//#GEN#[-1]#PJ#
                                } else {//#GEN#[-1]#PJ#
                                    lf.apply(dec_lf);//#GEN#[-1]#PJ#
                                }//#GEN#[-1]#PJ#
                            }//#GEN#[-1]#PJ#
                        }//#GEN#[-1]#PJ#
                        break;//#GEN#[-1]#PJ#
                }//#GEN#[-1]#PJ#
            }if (OMP_end == OMP_local_iterator) {
                //BEGIN lastprivate variables value set
                //END lastprivate variables value set
            }

        }
    }
    //BEGIN shared, reduction, lastprivate, update outputlist
    //END shared,reduction, lastprivate, update outputlist
    PjRuntime.setBarrier();
}
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
}//#GEN#[-1]#PJ#
