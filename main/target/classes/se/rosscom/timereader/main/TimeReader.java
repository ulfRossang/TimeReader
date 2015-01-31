package se.rosscom.timereader.main;

/**
 *
 * @author ulfrossang
 */
public class TimeReader implements Runnable {
    
    public static Thread instance;
    public static TimeReaderServiceImpl timeReaderSeviceImpl;
    
    public TimeReader() {
//        run();
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("Timereader *********");
        if (args != null) {
            if (args[0] != null && args[0].equals("start")) {
                System.out.println("arg: "+ args[0]);
                TimeReader timeReader = new TimeReader();
                timeReader.run();
                
            } else {
                TimeReader timeReader = new TimeReader();
                timeReader.stop();
                
            }
            
        } 
        
    }

    @Override
    public void run() {
        System.out.println("TimeReaderServiceImpl.start ********");
        timeReaderSeviceImpl = new TimeReaderServiceImpl();
        timeReaderSeviceImpl.run();
        System.out.println("TimeReaderServiceImpl.started ********");

    }
    
    public void stop() {
        timeReaderSeviceImpl = new TimeReaderServiceImpl();
        timeReaderSeviceImpl.stop();
        System.out.println("TimeReaderServiceImpl.stop ********");

        
        
    }
    
    
}
