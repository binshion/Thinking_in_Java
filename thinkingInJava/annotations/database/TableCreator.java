package thinkingInJava.annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws Exception{
        if (args.length < 1) {
            args = new String[]{"thinkingInJava.annotations.database.Member"};
        }

        if (args.length < 1) {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }

        for (String className : args) {
            Class<?> cl = Class.forName(className);  //使用forName()加载每一个类
            DBTable dbTable = cl.getAnnotation(DBTable.class);  //检查该类是否带有@DBTable注解
            if (dbTable == null) {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }

            String tableName = dbTable.name();  //如果有该注解，将表名保存下来
            if (tableName.length() < 1) {   //注解中取到的默认值或值为空时，使用类名做表名
                tableName = cl.getName().toUpperCase();
            }

            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields()) {  //读取这个类的所有域
                String columnName = null;

                //进行检查，返回这个域上的所有注解的数组
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }

                //Int类型
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sInt = (SQLInteger) anns[0];
                    if (sInt.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }

                    columnDefs.add(columnName + " INT" + getConstraints(sInt.constraints()));
                }

                //Varchar类型
                if (anns[0] instanceof SQLString) {
                    SQLString sString = (SQLString) anns[0];
                    if (sString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sString.name();
                    }

                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" +
                        getConstraints(sString.constraints()));
                }


            }

            StringBuilder createCommand = new StringBuilder(
                    "CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs) {
                createCommand.append("\n    " + columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";

            System.out.println("Table.Creation SQL for " + className + "is :\n" +
                    tableCreate);
        }
    }

    private static String getConstraints(Constraints con) {
        String constraints = "";
        if (!con.allowNull()) {
            constraints += " NOT NULL";
        }
        if (con.primaryKey()) {
            constraints += " PRIMARY KEY";
        }
        if (con.unique()) {
            constraints += " UNIQUE";
        }

        return constraints;
    }
}
