package service;

import entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public AccountService(JpaTransactionManager jpaTransactionManager) {
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferMoney(int sourceAccountId, int targetAccountId,double amount) throws Exception{
            AccountEntity sourceAccount = accountRepository.findById(sourceAccountId).get();
            AccountEntity targetAccount = accountRepository.findById(targetAccountId).get();

            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            accountRepository.save(sourceAccount);
            if (sourceAccount.getBalance()<0){
                throw new Exception("amount to tranfer more than balance.");
            }
            targetAccount.setBalance(targetAccount.getBalance() + amount);
            accountRepository.save(targetAccount);
    }
}
