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

import com.iflytek.voicecloud.client.LfasrClient;
import com.iflytek.voicecloud.exception.LfasrException;
import com.iflytek.voicecloud.model.LfasrType;
import com.iflytek.voicecloud.model.Message;

/**
 * @author Jack Mo
 *
 */
public class VoiceRecognizer {
	
	private LfasrClient client;
	
	public VoiceRecognizer(String appId, String secretKey) throws Exception {
		LfasrType type = LfasrType.LFASR_STANDARD_RECORDED_AUDIO;
		client = LfasrClient.InitClient(appId, secretKey, type);
	}
	
	public Message upload(String file) throws Exception {
		Message message = client.lfasr_upload(file);
		return message;
	}
	
	public Message result(String taskId) throws LfasrException {
		Message message = client.lfasr_get_result(taskId);
		return message;
	}
	
}
