@Test public void combined(){
  assertEquals("3, 3, 2, 1",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),false,Long.MAX_VALUE,0,null,settings)));
  assertEquals("3, 2, 1",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),true,Long.MAX_VALUE,0,null,settings)));
  assertEquals("1, 2, 3, 3",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),false,Long.MAX_VALUE,0,INT_COMP,settings)));
  assertEquals("1, 2, 3",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),true,Long.MAX_VALUE,0,INT_COMP,settings)));
  assertEquals("3, 3",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),false,2,0,null,settings)));
  assertEquals("3, 2, 1",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),false,Long.MAX_VALUE,1,null,settings)));
  assertEquals("3, 2",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),false,2,1,null,settings)));
  assertEquals("2, 1",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),true,2,1,null,settings)));
  assertEquals("2, 3",toString(FilterIterators.newCombinedFilter(it(3,3,2,1),true,2,1,INT_COMP,settings)));
}
