@Test public void testStringsProperty(){
  PropertyBuilder builder=PropertyBuilder.array(Type.STRING);
  builder.setName("foo").addValue("one").addValue("two");
  assertEquals(MultiStringPropertyState.stringProperty("foo",Arrays.asList("one","two")),builder.getPropertyState());
  builder.setScalar();
  try {
    builder.getPropertyState();
  }
 catch (  IllegalStateException expected) {
  }
  builder.removeValue("one");
  assertEquals(StringPropertyState.stringProperty("foo","two"),builder.getPropertyState());
}
