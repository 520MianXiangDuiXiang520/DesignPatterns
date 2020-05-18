package pers.junebao.prototype_pattern.deep_copy;

import java.io.*;

public class DeepClone implements Serializable {

    public static Object deepClone(Object obj) {
        Object result = null;
        //序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream  ois = null;
        try {
            ois = new ObjectInputStream(bais);
            result = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;

    }
}
