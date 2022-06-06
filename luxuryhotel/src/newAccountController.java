import java.util.ArrayList;
import java.util.List;

public class newAccountController {
    private Account accObj;

    public Account getAccount(){
        return accObj;
    }

    public newAccountController(Account accObj){
        this.accObj = accObj;
    }

    public void create_account(String name, Integer pass, String email, Integer phone){
        List<Object> listCheck;
        listCheck  = accountValid(name , email);
        if(!(boolean) listCheck.get(0)){
            
        }

    }


    public List<Object> accountValid(String name, String email){
        List<Object> list = new ArrayList<>();
        int index = 0;
        //boolen valid = true;
        index  = Account.getAccounts().search("un", name);
        if(index != -1){
            //valid = false;
            list.add(false); //0
            list.add("[USERNAME EXISTS] An user with that username already exists.");//1
            return list;
        }
        index = Account.getAccounts().search("email", email);
        if(index != -1 ){
            //valid = false
            list.add(false);
            list.add("[EMAIL EXISTS] A mail with that email already exists");
            return list;
        }
        if(index == -1){
            //true
            list.add(true);
            list.add("[ACCOUNT_CREATE] An account has been created.");
        }
        return list;

    }
}
