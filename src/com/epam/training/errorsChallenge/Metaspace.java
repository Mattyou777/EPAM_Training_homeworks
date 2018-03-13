import javassist.CannotCompileException;
public class Metaspace {

    static javassist.ClassPool cp = javassist.ClassPool.getDefault();

    static void thrower(){

        for (int i = 0; ; i++) {
            try {
                Class c = cp.makeClass("eu.plumbr.demo.Generated" + i).toClass();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }

    }

}
