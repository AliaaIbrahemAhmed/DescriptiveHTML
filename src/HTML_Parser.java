import java.util.Vector;

public class HTML_Parser {
    String html(Vector<Element> inputs) {
        String output = "";
        int headerID = 1;
        for (int i = inputs.size() - 1; i >= 0; i--) {
            Element element = inputs.get(i);
            String style="";
            if(element.getColor()!=null) style += "style=\"color:"+element.getColor()+";";
            if(element.getFont()!=null) {
                if(style.isEmpty()) style+= "style=\"";
                style += "font-family:"+element.getFont()+";";
            }
            if(!style.isEmpty())style+="\"";
            String s = style.isEmpty() ? "" : " " + style;
            switch (element.getType()) {
                case "image":
                    output += "<img src=\"" + element.getText() + "\"/>\n";
                    break;
                case "paragraph":
                    output += "<p" + s + ">" + element.getText() + "</p>\n";
                    break;
                case "header":
                    String headerName = "h" + headerID;
                    headerID++;
                    output += "<" + headerName + s + ">" + element.getText() + "</" + headerName + ">\n";
                    break;
                case "link":
                    output += "<a href=\"" + element.getUrl() + style + ">" + element.getText() + "</a>\n";
                    break;
                default:
                    break;
            }
        }
        return output;
    }
}
