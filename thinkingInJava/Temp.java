package thinkingInJava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Temp {
    public static void main(String[] args) {
        StringBuffer accountWhr = new StringBuffer();

        Set<String> result = new HashSet<>();
        for(int i = 1; i <= 1000; i++){
            result.add(Integer.toString(i));
        }

        Iterator it = result.iterator();
        int accountCount = result.size();
        if(accountCount > 999){
            int times = accountCount / 999 + (accountCount % 999 == 0 ? 0 : 1);
            for (int i = 1; i <= times; i++) {
                if(i == 1){
                    accountWhr.append(" and (");
                    accountWhr.append("b.faccountid in(");
                }
                if(i > 1){
                    accountWhr.append(" or b.faccountid in(");
                }

                for(int currentPos = (i - 1) * 999 + 1; currentPos <= i * 999 && currentPos <= accountCount; currentPos++){
                    accountWhr.append("'").append(it.next()).append("'");

                    if(currentPos == i * 999 || currentPos == accountCount){
                        accountWhr.append(")");
                    }else {
                        accountWhr.append(", ");
                    }
                }

                if(i == times){
                    accountWhr.append(")");
                }
            }
        }else if(accountCount == 0){
            accountWhr.append(" and 1 = 0 ");
        }
        else {
            if(it.hasNext()){
                accountWhr.append(" and b.accountid in ('").append(it.next()).append("'");
            }
            while (it.hasNext()){
                accountWhr.append(", '").append(it.next()).append("'");
            }
            accountWhr.append(") ");
        }

        System.out.println(accountWhr.toString());
    }
}
