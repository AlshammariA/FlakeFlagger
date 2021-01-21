@Test public void sort(){
  assertEquals("",toString(FilterIterators.newSort(it(new Integer[]{}),INT_COMP,0,settings)));
  assertEquals("",toString(FilterIterators.newSort(it(1),INT_COMP,0,settings)));
  assertEquals("1",toString(FilterIterators.newSort(it(1),INT_COMP,1,settings)));
  assertEquals("1",toString(FilterIterators.newSort(it(1),INT_COMP,2,settings)));
  assertEquals("1",toString(FilterIterators.newSort(it(1,2),INT_COMP,1,settings)));
  assertEquals("1",toString(FilterIterators.newSort(it(2,1),INT_COMP,1,settings)));
  assertEquals("1, 2",toString(FilterIterators.newSort(it(1,2,3),INT_COMP,2,settings)));
  assertEquals("1, 2",toString(FilterIterators.newSort(it(3,2,1),INT_COMP,2,settings)));
  assertEquals("1, 1, 2",toString(FilterIterators.newSort(it(3,3,2,1,1),INT_COMP,3,settings)));
}
