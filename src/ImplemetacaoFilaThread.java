import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplemetacaoFilaThread extends Thread {

    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

    public void add(ObjetoFilaThread objetoFilaThread){
        pilha_fila.add(objetoFilaThread);
    }

    @Override
    public void run() {
        System.out.println("Fila em runtime");

        while(true){
            synchronized(pilha_fila){ /* bloquear o acesso deste processo por outra thread*/
                Iterator iterar = pilha_fila.iterator();
                while(iterar.hasNext()){ /* Enquanto houver dados na lista irá processar*/
                    ObjetoFilaThread processar = (ObjetoFilaThread) iterar.next();
                    /* inserir o processamento aqui*/
                    System.out.println("---------------------------------------");
                    System.out.println(processar.getNome());
                    System.out.println(processar.getEmail());
        
                    iterar.remove();
                    try {
                        Thread.sleep(1000); /* dar um tempo descarga de memória do JVM */
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                Thread.sleep(1000); /* após processar toda a lista dar um tempo descarga de memória do JVM */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
