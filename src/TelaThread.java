import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;

public class TelaTimeThread extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout());

    private JLabel nomeLabel = new JLabel("Nome");
    private JTextField nomeText = new JTextField();

    private JLabel emailLabel = new JLabel("E-mail");
    private JTextField emailText = new JTextField();

    private JButton jButtonStart = new JButton("Add Lista");
    private JButton jButtonStop = new JButton("Stop");

    private ImplemetacaoFilaThread filaThread = new ImplemetacaoFilaThread();

    public TelaTimeThread() {
        setTitle("Minha tela de instancição des thread");
        setSize(new DimensionUIResource(240, 240));
        setLocationRelativeTo(null);
        setResizable(false);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new InsetsUIResource(5, 10, 5, 5);
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        nomeLabel.setPreferredSize(new DimensionUIResource(200, 25));
        jPanel.add(nomeLabel, gridBagConstraints);

        gridBagConstraints.gridy++;
        nomeText.setPreferredSize(new DimensionUIResource(200, 25));
        jPanel.add(nomeText, gridBagConstraints);

        gridBagConstraints.gridy++;
        emailLabel.setPreferredSize(new DimensionUIResource(200, 25));
        jPanel.add(emailLabel, gridBagConstraints);

        gridBagConstraints.gridy++;
        emailText.setPreferredSize(new DimensionUIResource(200, 25));
        jPanel.add(emailText, gridBagConstraints);

        gridBagConstraints.gridy++;
        gridBagConstraints.gridwidth = 1;
        jButtonStart.setPreferredSize(new DimensionUIResource(92, 25));
        jPanel.add(jButtonStart, gridBagConstraints);

        gridBagConstraints.gridx++;
        jButtonStop.setPreferredSize(new DimensionUIResource(92, 25));
        jPanel.add(jButtonStop, gridBagConstraints);

        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filaThread==null){
                    filaThread=new ImplemetacaoFilaThread();
                    filaThread.start();
                }
                ObjetoFilaThread objetoFilaThread = new ObjetoFilaThread(nomeText.getText(), emailText.getText());
                filaThread.add(objetoFilaThread);
            }
        });

        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filaThread.stop();
                filaThread=null;
            }
        });

        filaThread.start();

        add(jPanel, BorderLayout.WEST);
        setVisible(true);
    }

}
