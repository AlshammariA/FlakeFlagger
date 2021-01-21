@Test public void offset(){
  assertEquals("",toString(FilterIterators.newOffset(it(),0)));
  assertEquals("1",toString(FilterIterators.newOffset(it(1),0)));
  assertEquals("1, 2",toString(FilterIterators.newOffset(it(1,2),0)));
  assertEquals("",toString(FilterIterators.newOffset(it(),1)));
  assertEquals("",toString(FilterIterators.newOffset(it(1),1)));
  assertEquals("2",toString(FilterIterators.newOffset(it(1,2),1)));
  assertEquals("",toString(FilterIterators.newOffset(it(1,2),2)));
  assertEquals("",toString(FilterIterators.newOffset(it(1,2),3)));
  assertEquals("2, 3",toString(FilterIterators.newOffset(it(1,2,3),1)));
}
