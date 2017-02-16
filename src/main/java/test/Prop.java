/**
 * Copyright (c) 2016, Jack Mo (mobangjack@foxmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Jack Mo
 *
 */
public class Prop {

	private Properties properties;
	
	public Prop(String file) throws Exception {
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(new File(file));
			properties = new Properties();
			properties.load(inputStream);
		} catch (Exception e) {
			properties = null;
		}finally {
			if (inputStream != null) {
				close(inputStream);
				inputStream = null;
			}
		}
	}
	
	public String get(String key) {
		return properties.getProperty(key);
	}
	
	public String get(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}
	
	private static void close(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
				closeable = null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
