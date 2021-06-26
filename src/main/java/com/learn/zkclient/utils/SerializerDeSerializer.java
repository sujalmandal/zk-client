package com.learn.zkclient.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface SerializerDeSerializer {
	
	public static byte[] serialize(Serializable obj) {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
		         ObjectOutputStream out = new ObjectOutputStream(bos)) {
		        out.writeObject(obj);
		        return bos.toByteArray();
		    } catch (IOException e) {
				e.printStackTrace();
			}
		return null; 
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(byte[] bytes) {
		try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		         ObjectInputStream in = new ObjectInputStream(bis)) {
		        return (T) in.readObject();
		    } catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		return null; 
	}
}