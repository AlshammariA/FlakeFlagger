@Test public void allShortcutsExcludeAll(){
  FilterBuilder builder=new FilterBuilder();
  Condition condition=builder.all(builder.path("path"),builder.excludeAll(),builder.path("path"));
  assertEquals(ConstantFilter.EXCLUDE_ALL,condition.createFilter(EMPTY_NODE,EMPTY_NODE,"/"));
}
