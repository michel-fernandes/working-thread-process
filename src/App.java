public class App {

    public static void main(String[] args) throws Exception {
        
        TelaTimeThread telaTimeTrhead = new TelaTimeThread();

        /* 
        Thread threadEmailObj = new Thread(threadEmail);
        threadEmailObj.start();

        Thread threadNFEObj = new Thread(threadNFE);
        threadNFEObj.start();
        */
    }

    /*
    private static Runnable threadEmail = new Runnable() {
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("Processando trhead de email");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private static Runnable threadNFE = new Runnable() {
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                System.out.println("Processando trhead de NFE");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    */
}
