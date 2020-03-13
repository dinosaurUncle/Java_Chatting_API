package me.dinosauruncle.chatting_api.service;

import me.dinosauruncle.chatting_api.domain.Account;
import me.dinosauruncle.chatting_api.repository.AccountRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Transactional
@Service
public class AccountServiceImpl extends AccountService{
    private static Logger logger = LogManager.getLogger();
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Map<String, Object> parameterMap;

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public Account updateAccount(String id, Account account) {
        return null;
    }

    @Override
    public Map<String, Object> deleteAccount(String id) {
        return null;
    }

    @Override
    public  Map<String, Object> isId(String id) {
        Account account = null;
        try {
            account = accountRepository.findById(id).get();
        } catch (Exception e){
            logger.error("id에 해당하는 계정이 존재하지 않습니다");
        }
        if (account != null) parameterMap.put("isId", "true");
        else parameterMap.put("isId", "true");
        return parameterMap;
    }

    @Override
    public Map<String, Object> findNameAndEmailReturnId(String name, String email) {
        parameterMap.put("id", accountRepository.selectId(name, email));
        return parameterMap;
    }

    @Override
    public Map<String, Object> newAccountResult(Account account) {
        parameterMap.put("account", account);
        try {
            passwordTransEncode(account);
            Account returnAccount = accountRepository.save(account);
            parameterMap.put("state", "S");
        } catch (Exception e) {
            parameterMap.put("state", "F");
        }
        return parameterMap;
    }

    @Override
    public Map<String, Object> addKeyEndValue(String key, Object value) {
        parameterMap.put(key, value);
        return parameterMap;
    }

    @Override
    public Map<String, Object> login(Account account) {
        parameterMap.clear();
        boolean result = false;
        Account selectAccount = null;
        try {
            selectAccount = accountRepository.findById(account.getId()).get();
            if (passwordEncoder.matches(account.getPassword(), selectAccount.getPassword())){
                parameterMap.put("login", true);
                logger.info("로그인 성공");
            } else {
                String message = "ID와 비밀번호가 불일치 합니다";
                parameterMap.put("login", false);
                parameterMap.put("message", message);
                logger.info("로그인 실패");
            }
        } catch (NoSuchElementException e){
            String message = "존재하지 않는 아이디 입니다";
            parameterMap.put("login", false);
            parameterMap.put("message", message);
            logger.error(message);

        } catch (NullPointerException e){
            String message = "존재하지 않는 아이디 입니다";
            this.parameterMap.put("login", false);
            this.parameterMap.put("message", message);
            logger.error(message);
        }
        return this.parameterMap;
    }

    private void passwordTransEncode(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
    }

    @Override
    public Map<String, Object> findById(String id) {
        try {
            parameterMap.put("account", accountRepository.findById(id).get());
        } catch (NoSuchElementException e){
            String message = "존재하지 않는 아이디 입니다";
            logger.error(message);
            parameterMap.put("message", message);
        }
        return parameterMap;
    }

    public Map<String, Object> getParameterMap() {
        return parameterMap;
    }
}
