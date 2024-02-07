package factories;

public class WebPageFactory{


    private static final WebPageFactory pageFactory = new WebPageFactory();
    public WebPageFactory() {
    }
    public static WebPageFactory getInstance(){
        return pageFactory;
    }


}
