@Test public void testAssignFromStrings(){
  PropertyState source=MultiStringPropertyState.stringProperty("foo",Arrays.asList("1","2","3"));
  PropertyBuilder builder=PropertyBuilder.scalar(Type.LONG);
  builder.assignFrom(source);
  assertEquals(MultiLongPropertyState.createLongProperty("foo",Arrays.asList(1L,2L,3L)),builder.getPropertyState());
}
