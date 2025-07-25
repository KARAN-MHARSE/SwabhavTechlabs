class Main{
    public static void main(String args[]){
        ShoppingCart cart = new ShoppingCart();

        cart.addItemToCart(new Chocolate("Dark",100));

        cart.displayCart();
    }
}