package Test;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
import pj.parser.ast.visitor.DummyClassToDetermineVariableType;//#GEN#[-1]#PJ#
import java.util.concurrent.atomic.AtomicInteger;//#GEN#[-1]#PJ#
import pj.*;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
import pj.pr.*;//#GEN#[-1]#PJ#
import pj.PjRuntime;//#GEN#[-1]#PJ#
import java.util.concurrent.*;//#GEN#[-1]#PJ#
import java.util.concurrent.atomic.AtomicInteger;//#GEN#[-1]#PJ#
import java.util.concurrent.locks.ReentrantLock;//#GEN#[-1]#PJ#
import javax.swing.SwingUtilities;//#GEN#[-1]#PJ#
import java.lang.reflect.InvocationTargetException;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
public class Atom {//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    public static void main(String[] arg) {{//#GEN#[-1]#PJ#
        AtomicInteger a = new AtomicInteger(0);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#0) -- START *///#GEN#[-1]#PJ#
        InternalControlVariables icv_previous__OMP_ParallelRegion_0 = PjRuntime.getCurrentThreadICV();//#GEN#[-1]#PJ#
        InternalControlVariables icv__OMP_ParallelRegion_0 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        int _threadNum__OMP_ParallelRegion_0 = icv__OMP_ParallelRegion_0.nthreads_var.get(icv__OMP_ParallelRegion_0.levels_var);//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        inputlist__OMP_ParallelRegion_0.put("a",a);
        _OMP_ParallelRegion_0 _OMP_ParallelRegion_0_in = new _OMP_ParallelRegion_0(_threadNum__OMP_ParallelRegion_0,icv__OMP_ParallelRegion_0,inputlist__OMP_ParallelRegion_0,outputlist__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        _OMP_ParallelRegion_0_in.runParallelCode();//#GEN#[-1]#PJ#
        a = (AtomicInteger)outputlist__OMP_ParallelRegion_0.get("a");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#0) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    //Pyjama runtime shutdown at the end of main method
    PjRuntime.shutdown();
    }
static class _OMP_ParallelRegion_0{
        private int OMP_threadNumber = 1;
        private InternalControlVariables icv;
        private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
        private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
        private CyclicBarrier OMP_barrier;
        private ReentrantLock OMP_lock;

        //#BEGIN shared variables defined here
        AtomicInteger a = null;
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
            a = (AtomicInteger)OMP_inputList.get("a");
            //#END shared variables initialised here
        }

        private void updateOutputListForSharedVars() {
            //BEGIN update outputlist
            OMP_outputList.put("a",a);
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
                    _OMP_WorkShare_0_OMP_inputList.put("a",a);
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
    AtomicInteger a = null;
    a = (AtomicInteger)OMP_inputList.get("a");
    //#END shared variables defined and initialized here
    int OMP_iterator = 0;
    int i;
    int OMP_end = (int)((10000)-(0))/(1);
    if (((10000)-(0))%(1) == 0) {
        OMP_end = OMP_end - 1;
    }
    int __omp_loop_thread_num = Pyjama.omp_get_thread_num();
    int __omp_loop_num_threads = Pyjama.omp_get_num_threads();
    for (OMP_iterator=__omp_loop_thread_num*1; OMP_iterator<=OMP_end; OMP_iterator=OMP_iterator+__omp_loop_num_threads*1) {
        for (int OMP_local_iterator = OMP_iterator; OMP_local_iterator<OMP_iterator+1 && OMP_local_iterator<=OMP_end; OMP_local_iterator++){
            i = 0 + OMP_local_iterator * (1);
            {//#GEN#[-1]#PJ#
                a.incrementAndGet();//#GEN#[-1]#PJ#
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
