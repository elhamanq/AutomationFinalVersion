package FinalVersion;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ExecutionTime extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				 long startTime = System.currentTimeMillis();
			        int i = 0;
			        while (true) {
			        //    System.out.println(this.getName() + ": New Thread is running..." + i++);
			            try {
			                //Wait for one sec so it doesn't print too fast
			                Thread.sleep(1000);
			            } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
			}
			}});

	}

}
