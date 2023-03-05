import java.util.Set;

public class Rule implements Comparable<Rule> {

    private Set<String> LHS;
    private String RHS;

    public Rule(Set<String> LHS, String RHS) {
        this.LHS = LHS;
        this.RHS = RHS;
    }

    public Set<String> getLHS() {
        return LHS;
    }
    public String getRHS() {
        return RHS;
    }

    public boolean matches(String ...element) {
    	boolean contain=true;
    	for(String s : element) {
    		if(!LHS.contains(s)) {
    			contain=false;
    			break;
    		}
    	}
        return (contain&&(LHS.size()==element.length));
    }

    public void print() {

        System.out.println("-- NEW RULE --");
        System.out.println("--LHS: ");
        for (String s : LHS)System.out.println("|"+s+"|");
        System.out.println("--RHS: ");
        System.out.println("|"+RHS+"|");

    }

    @Override
    public int compareTo(Rule o) {
        boolean LHS_igual=this.LHS.containsAll(o.getLHS())&&(o.getLHS().containsAll(this.LHS));
        boolean RHS_igual=this.RHS.equals(o.getRHS());
        if (LHS_igual && RHS_igual) return 0;
        return 1;
    }
}
