package oles.jacek.main;

import java.io.PrintWriter;

// Functional Interface / SAM
@FunctionalInterface
public interface FIOutputPrinter {
    public static final PrintWriter normalOutputChannel = new PrintWriter(System.out, false);
    public static final PrintWriter erroneousOutputChannel = new PrintWriter(System.err, false);
    // to guarantee System.out is flushed first and System.err is flushed after it
    // may vary from OS to OS
    public static final Long delayAfterFlush = 150L;

    public abstract String getOutput();

    default void printOutput(Class callingClassRef) {
        try {
            synchronized (normalOutputChannel) {
                normalOutputChannel.println(String.format("%s:\n\r%s", callingClassRef.getName(), getOutput()));
                normalOutputChannel.flush();
                unsafeSleep();
            }
        } catch (Exception e) {
            synchronized (erroneousOutputChannel) {
                erroneousOutputChannel.println(String.format("%s: %s", callingClassRef.getName(), e.getMessage()));
                erroneousOutputChannel.flush();
                unsafeSleep();
            }
        }
    }

    public static void unsafeSleep() {
        try {
            Thread.sleep(delayAfterFlush);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
