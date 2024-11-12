package jdbc;

import java.sql.ResultSet;

public class Records {
    private ResultSet resultSet;
    private boolean isValid = true;

    public Records(ResultSet results){
        if(results == null) isValid = false;
        resultSet = results;
    }

    public boolean isValid(){
        return isValid;
    }

    public void printRecords() {
        if (resultSet == null) {
            System.out.println("Cannot print ResultSet : Invalid Set");
            return;
        }

        try {
            int columnCount = resultSet.getMetaData().getColumnCount();

            System.out.println();
            while (resultSet.next()) {
                for(int i = 1; i<=columnCount; i++){
                    int type = resultSet.getMetaData().getColumnType(i);

                    if(type == 4){
                        // Integer
                        System.out.print(resultSet.getInt(i) + (i == columnCount ? "" : ", "));
                    }else if(type == 3){
                        // Double
                        System.out.print(resultSet.getDouble(i) + (i == columnCount ? "" : ", "));
                    }else{
                        // String
                        System.out.print(resultSet.getString(i) + (i == columnCount ? "" : ", "));
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
