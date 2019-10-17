package comp7700.storemanagementsystem;

import javax.swing.JFileChooser;

public class StoreManager {
    public static String DEFAULT_DB_FILE = "/Users/melanasmith/Documents/Auburn/Courses/Fall 2019 COMP 7706 Software Architecture/Activities/StoreManagementSystem/StoreManagementSystem.db";
    IDataAccess adapter;
    MainUI mainUI;

    static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {
            instance = new StoreManager();
            instance.setup();
        }
        return instance;
    }

    public IDataAccess getDataAccess() {
        return adapter;
    }

    private void setup() {
        String dbFile = DEFAULT_DB_FILE;
        if (dbFile.length() == 0) {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Select the DB file!!!");
            int r = fc.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION)
                dbFile = fc.getSelectedFile().getAbsolutePath();
        }
        
        adapter = new SQLiteDataAdapter();
        if (adapter.connect(dbFile)) {
            System.out.println("Connection to SQLite has been established.");
        }
        else {
            System.out.println(adapter.getErrorMessage());
        }
        
        mainUI = new MainUI();
    }

    public void run() {
        mainUI.view.setVisible(true);
    }
}
