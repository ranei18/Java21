import nu.xom.*;

public class RssFilter{
    public static void main(String[] args){
        if(args.length < 2) {
            System.out.println("Usage: java RssFilter file term");
            System.exit(-1);
        }
        //save rss location and search term
        String rssFile = args[0];
        String term = args[1];
        
        try {
            Builder bob = new Builder();
            Document doc = bob.build(rssFile);
            
            Element rss = doc.getRootElement();
            Attribute rssVersion = rss.getAttribute("version");
            String version = rssVersion.getValue();
            
            //add the dtd for rss 0.91 feeds, if needed
            if((version.equals("0.91")) & (doc.getDocType() == null)) {
                DocType rssDtd = new DocType("rss","http://my.netscape.com/public/formats/rss-0.91.dtd");
                doc.insertChild(rssDtd, 0);
            }
            // get the first (and only) element
            Element channel = rss.getFirstChildElement("channel");
            //get title element
            Element title = channel.getFirstChildElement("title");
            Text titleText = (Text) title.getChild(0);
            //change the title to reflect the search term
            titleText.setValue(titleText.getValue() + ": Search for " + term + " articles");
            
            //get all of the item elements and loop through
            Elements items = channel.getChildElements("item");
            for (int i = 0; i < items.size(); i++){
                Element item = items.get(i);
                Element iTitle = item.getFirstChildElement("title");
                
                //if found, look at its contents
                if(iTitle != null) {
                    Text iTitleText = (Text) iTitle.getChild(0);
                    //if not found, delete the item from the tree
                    if(iTitleText.toString().indexOf(term) == -1) {
                        channel.removeChild(item);
                    }
                }
            }
            //display the results
            Serializer output = new Serializer(System.out);
            output.setIndent(2);
            output.write(doc);
            
            
        } catch(Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}