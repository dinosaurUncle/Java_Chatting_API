package me.dinosauruncle.chatting_api.controller;

import me.dinosauruncle.chatting_api.domain.Account;
import me.dinosauruncle.chatting_api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController(value = "/msa")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public Map<String, Object> newAccount(@RequestBody Account account) {
        return accountService.accountSaveAndUpdate(account);
    }
    @GetMapping("/account/{id}")
    public Map<String, Object> getAccountById(@PathVariable("id") String id) {
        return accountService.findById(id);
    }

    @GetMapping("/account")
    public Map<String, Object> getAccounts(){
        return accountService.getAccounts();
    }

    @PutMapping("/account")
    public Map<String, Object> updateAccount(@RequestBody Account account){
        return accountService.accountSaveAndUpdate(account);
    }
    @DeleteMapping("/account/{id}")
    public Map<String, Object> deleteAccount(@PathVariable("id") String id){
        return accountService.deleteAccount(id);
    }

    @GetMapping("/account/password/{email}")
    public String createTokenAndSendEmail(@PathVariable("email") String email) {
        return null;
    }



    @GetMapping("account/isId/{id}")
    public Map<String, Object> isId(@PathVariable("id") String id) {
        return accountService.isId(id);
    }

    @GetMapping("account/selectId/{name}/{email}")
    public Map<String, Object> findNameAndEmailReturnId(
            @PathVariable("name") String name, @PathVariable("email") String email){
        return accountService.findNameAndEmailReturnId(name, email);
    }

    @PostMapping("account/login")
    public Map<String, Object> login(@RequestBody Account account){
        return accountService.login(account);
    }




}
