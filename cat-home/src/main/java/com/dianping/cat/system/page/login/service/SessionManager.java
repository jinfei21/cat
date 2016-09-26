package com.dianping.cat.system.page.login.service;

import com.dianping.cat.system.page.login.spi.ISessionManager;

public class SessionManager implements ISessionManager<Session, Token, Credential> {

	@Override
	public Token authenticate(Credential credential) {
		String account = credential.getAccount();
		String password = credential.getPassword();

		if (account != null && password != null) {
			// default no authenticate
			if("catadmin".equals(account)&&"root".equals(password)){
				return new Token(account, account);
			}else{
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public Session validate(Token token) {
		LoginMember member = new LoginMember();

		member.setUserName(token.getUserName());
		member.setRealName(token.getRealName());

		return new Session(member);
	}
}
