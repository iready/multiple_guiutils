package org.zyq.mg.common

import com.jfinal.kit.Prop
import com.jfinal.kit.PropKit
import org.apache.commons.io.FileUtils
import org.apache.log4j.Logger

import javax.swing.JFrame

/**
 * Created by zouyq on 2016/3/11.
 */
class Config {
    private static final String configPath = "d:/config.inf";
    static Prop prop;
    private static Logger logger = Logger.getLogger("config");
    static JFrame jFrame = new JFrame("综合工具");
    static {
        try {
            File con = new File(configPath);
            if (!con.exists()) {
                FileUtils.touch(con)
            }
            prop = PropKit.use(con);
            jFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        } catch (Exception e) {
            logger.error(e)
        } finally {
            logger.info '初始化完成'
        }

    }

    public static void main(String[] args) {
        println 1
    }

    static void save() {
        prop.properties.store(FileUtils.openOutputStream(new File(configPath)), "")
    }

    static void set(String key, String value) {
        prop.properties.setProperty(key, value);
    }

    static void setAndSave(String key, String value) {
        set(key, value)
        save()
    }
}
