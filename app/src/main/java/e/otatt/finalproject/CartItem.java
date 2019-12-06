package e.otatt.finalproject;

public class CartItem extends ExampleItem {
    private int price;

    public CartItem(String mImageUrl, String mCreator, int mLikes, int price) {
        super(mImageUrl, mCreator, mLikes);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
