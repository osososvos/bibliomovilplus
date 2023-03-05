import java.util.Set;
import java.util.TreeSet;

public class RuleSet {

    private Set<Rule> rules;
    //@pre poner los contratos de las operaciones

    public RuleSet() {
        rules = new TreeSet<>();
    }

    public void addRule(Rule rule){
        rules.add(rule);
    }

    public void loadFromDisk(String path) {

        rules = DiskRuleManager.loadRules(path);
    }

    public void printRules() {
        for (Rule r : rules) r.print();
    }

    public Set<String> recommendedElements(String ...element) {
        Set<Rule> matchingRuleSet = matchingRules(element);
        Set<String> recommendations = new TreeSet<>();
        for (Rule r : matchingRuleSet) recommendations.add(r.getRHS());
        return recommendations;
    }
/* Transformar lista  de libros a mayúsculas
 */
    public Set<Rule> matchingRules(String ...element) {
        Set<Rule> matchingRuleSet = new TreeSet<>();
        for (Rule r : rules) if (r.matches(element)) matchingRuleSet.add(r);
        return matchingRuleSet;
    }
}
