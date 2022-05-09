package leetcode.editor.cn;

import java.io.File;

public class Demo1 {
    public static void main(String[] args) {
        File file = new File("D:\\log");
        dfs(file, 0);
        System.out.println(maxDep);
        Runtime.getRuntime().addShutdownHook( new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
        }));
        System.out.println("outer end");
    }

    static int maxDep=0;

    public static int dfs(File file, int dep){
        if(file == null){
            return dep;
        }
        if(!file.isDirectory()){
            return dep;
        }
        dep++;
        File[] files = file.listFiles();
        for (File file1 : files) {
            int d = dfs(file1, dep);
            maxDep = Math.max(d, maxDep);
        }
        return dep;
    }

}
