package com.spring.core.properties; /**
 * 
 */



/**
 * @author zhailiang
 *
 */
public class QQProperties{

	private String appId;
	private String appSecret;
	private String providerId = "qq";  //服务提供商的标识



	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return this.appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
}
