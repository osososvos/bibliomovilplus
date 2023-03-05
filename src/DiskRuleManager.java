import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class DiskRuleManager {

    public static Set<Rule> loadRules(String path) {

        Set<Rule> rules = new TreeSet<>();
        String line;
        try(BufferedReader br=new BufferedReader(new BufferedReader(new FileReader(path)))) {
            while ((line = br.readLine())!=null) {

                //Recortar los diferentes datos de la linea:
                int initCursor = line.indexOf("{") + 1;
                int fiCursor = line.indexOf("}");
                String lhs = line.substring(initCursor, fiCursor);
                initCursor = line.indexOf( "{", fiCursor) +1;
                fiCursor = line.indexOf("}", initCursor);
                String rhs = line.substring(initCursor, fiCursor);

                //Guardar los lhs en un set:
                Set<String> lhs_set = new TreeSet<>();
                String[] lhs_arr=lhs.split(",");
                for(String lhsi : lhs_arr)lhs_set.add(lhsi);

                //Añadir la regla al set:
                rules.add(new Rule(lhs_set, rhs));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rules;

    }

}
