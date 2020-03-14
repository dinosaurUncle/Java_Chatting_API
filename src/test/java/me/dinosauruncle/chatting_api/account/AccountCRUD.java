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
        account.save("IU4ever", "이지은", "pass", "1", "iu1234@naver.com", "010-1111-2222");
        accountService.accountSaveAndUpdate(account);
    }

    @Test
    public void getAccount(){
        accountService.findById("m05214");
    }

    @Test
    public void getAccounts(){
        accountService.getAccounts();
    }

    @Test
    public void update(){
        accountService.findById("IU4ever");
        Account account = new Account();
        account.save("IU4ever", "이지은", "pass", "1", "iu1234@naver.com", "010-3333-4444");
        accountService.accountSaveAndUpdate(account);
    }

    @Test
    public void delete(){
        accountService.deleteAccount("test123");
    }


}
