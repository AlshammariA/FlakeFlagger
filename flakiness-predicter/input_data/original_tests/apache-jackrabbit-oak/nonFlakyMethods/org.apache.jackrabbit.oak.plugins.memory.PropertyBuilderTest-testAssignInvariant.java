@Test public void testAssignInvariant(){
  PropertyState source=MultiStringPropertyState.stringProperty("source",Arrays.asList("1","2","3"));
  PropertyBuilder builder=PropertyBuilder.scalar(Type.STRING);
  builder.assignFrom(source);
  assertEquals(source,builder.getPropertyState());
}
