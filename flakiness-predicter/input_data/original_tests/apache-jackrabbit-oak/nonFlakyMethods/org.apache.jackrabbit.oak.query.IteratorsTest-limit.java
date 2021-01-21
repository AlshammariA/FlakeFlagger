@Test public void limit(){
  assertEquals("",toString(FilterIterators.newLimit(it(),0)));
  assertEquals("",toString(FilterIterators.newLimit(it(),1)));
  assertEquals("",toString(FilterIterators.newLimit(it(),10)));
  assertEquals("",toString(FilterIterators.newLimit(it(1),0)));
  assertEquals("1",toString(FilterIterators.newLimit(it(1),1)));
  assertEquals("1",toString(FilterIterators.newLimit(it(1),10)));
  assertEquals("",toString(FilterIterators.newLimit(it(1,2),0)));
  assertEquals("1",toString(FilterIterators.newLimit(it(1,2),1)));
  assertEquals("1, 2",toString(FilterIterators.newLimit(it(1,2),10)));
  assertEquals("1",toString(FilterIterators.newLimit(it(1,2,3),1)));
  assertEquals("1, 2",toString(FilterIterators.newLimit(it(1,2,3),2)));
  assertEquals("1, 2, 3",toString(FilterIterators.newLimit(it(1,2,3),3)));
  assertEquals("1, 2, 3",toString(FilterIterators.newLimit(it(1,2,3),4)));
}
