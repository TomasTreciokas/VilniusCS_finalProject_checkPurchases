package user;

public class YourBagFactory {

    private static YourBag bag = null;

    public static YourBag getYourBag() {
        if ( bag == null) {
            bag = new YourBag();
        }
        return bag;
    }

    @Deprecated
    // unit test use only
    public static void setBag(YourBag bag) {
        YourBagFactory.bag = bag;
    }
}
