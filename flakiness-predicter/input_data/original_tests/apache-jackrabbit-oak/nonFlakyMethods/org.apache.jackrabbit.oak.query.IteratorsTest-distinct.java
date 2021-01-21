@Test public void distinct(){
  assertEquals("",toString(FilterIterators.newDistinct(it(),settings)));
  assertEquals("1",toString(FilterIterators.newDistinct(it(1),settings)));
  assertEquals("1, 2",toString(FilterIterators.newDistinct(it(1,2),settings)));
  assertEquals("1, 2, 3",toString(FilterIterators.newDistinct(it(1,2,1,3,3,1),settings)));
}
