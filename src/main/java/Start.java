
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Start {

    public Start INSTANCE;
    public final HashMap<Integer, Agent> agentList = new HashMap<>();

    public String[] agentsName = { "Jordy", "Massi", "Victor","Maxime" };

    public static void main(String[] args) {
        new Start();
    }

    public Start() {
        addAgents();
        setAgentObject();
        INSTANCE = this;
        Thread t = new Thread(() -> {
            createHTMLBase();
        });
        Thread t2 = new Thread(() -> {
            createHTMLAgents();
        });
        t.start();
        t2.start();

    }

    private void setAgentObject() {
        //Agent1
        agentList.get(0).getListObject().get(0).setHasObject(true);
        agentList.get(0).getListObject().get(6).setHasObject(true);
        agentList.get(0).getListObject().get(4).setHasObject(true);
        //Agent2
        agentList.get(1).getListObject().get(1).setHasObject(true);
        agentList.get(1).getListObject().get(6).setHasObject(true);
        //Agent3
        agentList.get(2).getListObject().get(3).setHasObject(true);
        agentList.get(2).getListObject().get(0).setHasObject(true);
        //Agent4
        agentList.get(3).getListObject().get(0).setHasObject(true);
        agentList.get(3).getListObject().get(1).setHasObject(true);
        agentList.get(3).getListObject().get(2).setHasObject(true);
        agentList.get(3).getListObject().get(3).setHasObject(true);
        agentList.get(3).getListObject().get(4).setHasObject(true);
        agentList.get(3).getListObject().get(6).setHasObject(true);
    }   

    private void addAgents() {
        int i = 0;
        for (String s : agentsName) {
            HashMap<Integer, Object> map = new HashMap<>();
            map.put(0, new Object("Mousqueton", false));
            map.put(1, new Object("Gant d'intervention", false));
            map.put(2, new Object("Ceinture de sécurité tactique", false));
            map.put(3, new Object("Détecteur de métaux", false));
            map.put(4, new Object("Brassard de sécurité", false));
            map.put(5, new Object("Lampe Torche", false));
            map.put(6, new Object("Gilet Pare Balle", false));
            agentList.put(i, new Agent(s, map));
            i++;
        }

    }


    private void createHTMLBase() {

        try {
            PrintWriter writer = new PrintWriter("./docs/index.html", "UTF-8");
            writer.println("<!DOCTYPE HTML>");
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Securi GO</title>");
            writer.println("<meta charset=\"utf-8\" />");
            writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />");
            writer.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
            writer.println("<noscript><link rel=\"stylesheet\" href=\"assets/css/noscript.css\" /></noscript>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<header id=\"header\">");
            writer.println("<div class=\"content\">");
            writer.println("<h1><a href=\"#\">GO Securi</a></h1>");
            writer.println("<p>Vous accompagne depuis 2005<br />");
            writer.println("Sécurité, Gardiennage et Surveillance</p>");
            writer.println("<ul class=\"actions\">");
            for (int i = 0; i < agentList.size(); i++) {
                Agent agent = agentList.get(i);
                writer.println("<li><a href=\"" + agent.getName() + ".html\" class=\"button primary icon solid fa-download\">" + agent.getName() + "</a></li>");
            }
            writer.println("</ul>");
            writer.println("</div>");
            writer.println("<div class=\"image phone\"><div class=\"inner\"><img src=\"images/screen.jpg\" alt=\"\" /></div></div>");
            writer.println("</header>");
            writer.println("</body>");
            writer.println("</html>");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createHTMLAgents() {

        for (int i = 0; i < agentList.size(); i++) {
            Agent agent = agentList.get(i);

            try {
                PrintWriter writer = new PrintWriter(  "./docs/" + agent.getName() + ".html", "UTF-8");
                writer.println("<!DOCTYPE HTML>");
                writer.println("<html>");
                writer.println("<head>");
                writer.println("<title>Securi GO</title>");
                writer.println("<meta charset=\"utf-8\" />");
                writer.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />");
                writer.println("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />");
                writer.println("<noscript><link rel=\"stylesheet\" href=\"assets/css/noscript.css\" /></noscript>");
                writer.println("</head>");
                writer.println("<body>");
                writer.println("<header id=\"header\">");
                writer.println("<div class=\"content\">");
                writer.println("<h1><a href=\"#\">"+ agent.getName() +"</a></h1>");

                for (int o = 0; o < agent.getListObject().size(); o++) {
                    Object object = agent.getListObject().get(o);

                    if(object.isHasObject()) {
                        writer.println("<div>");
                        writer.println("<input type=\"checkbox\" id=\"" + o +"\" name=\""+ o + "\" disabled checked>");
                        writer.println("<label for=\""+ o +"\">" + object.getName() + "</label>");
                        writer.println("</div>");

                    }else {
                        writer.println("<div>");
                        writer.println("<input type=\"checkbox\" id=\"" + o +"\" name=\""+ o + "\" disabled>");
                        writer.println("<label for=\""+ o +"\">" + object.getName() + "</label>");
                        writer.println("</div>");
                    }

                }

                writer.println("<ul class=\"actions\">");
                writer.println("<li><a href=\"index.html\" class=\"button primary icon solid fa-download\">Retour</a></li>");
                writer.println("</ul>");
                writer.println("</div>");
                writer.println("<div class=\"image phone\"><div class=\"inner\"><img src=\"images/" + agent.getName() + ".png\" alt=\"\" /></div></div>");
                writer.println("</header>");
                writer.println("</body>");
                writer.println("</html>");
                writer.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}