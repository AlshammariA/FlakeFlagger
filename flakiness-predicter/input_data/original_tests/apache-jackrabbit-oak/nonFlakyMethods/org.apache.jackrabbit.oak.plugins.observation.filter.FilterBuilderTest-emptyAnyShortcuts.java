@Test public void emptyAnyShortcuts(){
  FilterBuilder builder=new FilterBuilder();
  Condition condition=builder.any();
  assertEquals(ConstantFilter.EXCLUDE_ALL,condition.createFilter(EMPTY_NODE,EMPTY_NODE,"/"));
}
