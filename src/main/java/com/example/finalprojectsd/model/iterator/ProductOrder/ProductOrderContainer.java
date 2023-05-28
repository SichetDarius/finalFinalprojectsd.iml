package com.example.finalprojectsd.model.iterator.ProductOrder;

import com.example.finalprojectsd.model.ProductOrder;
import com.example.finalprojectsd.model.iterator.Container;
import com.example.finalprojectsd.model.iterator.Iterator;

public class ProductOrderContainer implements Container<ProductOrder> {

    private final ProductOrder[] productOrders;
    public ProductOrderContainer(ProductOrder[] productOrders) {
        this.productOrders = productOrders;
    }
    @Override
    public Iterator<ProductOrder> getIterator() {
        return new ProductOrderIterator();
    }

    private class ProductOrderIterator implements Iterator<ProductOrder>{
        private int index;
        private ProductOrderIterator(){
            this.index = 0;
        }
        @Override
        public boolean hasNext() {
            return index < productOrders.length;
        }

        @Override
        public ProductOrder next() {
            if (hasNext()){
                return productOrders[index++];
            }
            return null;
        }
    }
}
