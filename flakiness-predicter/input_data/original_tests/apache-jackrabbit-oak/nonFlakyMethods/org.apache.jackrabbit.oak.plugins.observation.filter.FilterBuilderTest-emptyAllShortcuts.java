@Test public void emptyAllShortcuts(){
  FilterBuilder builder=new FilterBuilder();
  Condition condition=builder.all();
  assertEquals(ConstantFilter.INCLUDE_ALL,condition.createFilter(EMPTY_NODE,EMPTY_NODE,"/"));
}
