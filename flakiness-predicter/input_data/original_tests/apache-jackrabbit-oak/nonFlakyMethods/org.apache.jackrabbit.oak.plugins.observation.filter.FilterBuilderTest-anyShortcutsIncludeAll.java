@Test public void anyShortcutsIncludeAll(){
  FilterBuilder builder=new FilterBuilder();
  Condition condition=builder.any(builder.path("path"),builder.includeAll(),builder.path("path"));
  assertEquals(ConstantFilter.INCLUDE_ALL,condition.createFilter(EMPTY_NODE,EMPTY_NODE,"/"));
}
