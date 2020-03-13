package me.dinosauruncle.chatting_api.account;

import me.dinosauruncle.chatting_api.domain.Account;
import me.dinosauruncle.chatting_api.service.AccountService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountCRUD {

    private Logger logger = LoggerFactory.getLogger(AccountCRUD.class);

    @Autowired
    AccountService accountService;

    @Test
    public void save(){
        Account account = new Account();
        account.save("m05214", "박종훈", "pass", "0", "m05214@naver.com", "010-1111-2222");
        accountService.newAccountResult(account);
    }

    @Test
    public void getAccount(){
        accountService.findById("m05214").toString();
    }


}
