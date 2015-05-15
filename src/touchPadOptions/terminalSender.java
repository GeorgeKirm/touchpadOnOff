package touchPadOptions;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author georkirm
 */
public class terminalSender {
    private Process process;
    private Runtime runTime;
    terminalSender(){
        process = null;
    }
    void sendCommand(int choice){
        try{
            runTime = Runtime.getRuntime();
            process = runTime.exec("synclient TouchpadOff=" + choice);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Something went wrong.", "Touchpad Options", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }
            process.destroy();
        }catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong.", "Touchpad Options", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }
}
