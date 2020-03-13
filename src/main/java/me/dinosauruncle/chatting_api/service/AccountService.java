package me.dinosauruncle.chatting_api.service;

import me.dinosauruncle.chatting_api.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public abstract class AccountService {

    protected Map<String, Object> parameterMap;

    public void setParameterMap(Map<String, Object> parameterMap) {
        this.parameterMap = parameterMap;
    }

    public abstract List<Account> getAccounts();
    public abstract Account updateAccount(String id, Account account);
    public abstract Map<String, Object> deleteAccount(String id);
    public abstract Map<String, Object> findNameAndEmailReturnId(String name, String email);
    public abstract Map<String, Object> isId(String id);
    public abstract Map<String, Object> addKeyEndValue(String key, Object value);
    public abstract Map<String, Object> findById(String id);
    public abstract Map<String, Object> newAccountResult (Account account);
    public abstract Map<String, Object> login(Account account);
}
