@Test public void testAssignFromLongs(){
  PropertyState source=MultiLongPropertyState.createLongProperty("foo",Arrays.asList(1L,2L,3L));
  PropertyBuilder builder=PropertyBuilder.scalar(Type.STRING);
  builder.assignFrom(source);
  assertEquals(MultiStringPropertyState.stringProperty("foo",Arrays.asList("1","2","3")),builder.getPropertyState());
}
