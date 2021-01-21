@Test public void testStringProperty(){
  PropertyBuilder builder=PropertyBuilder.scalar(Type.STRING);
  builder.setName("foo").setValue("bar");
  Assert.assertEquals(StringPropertyState.stringProperty("foo","bar"),builder.getPropertyState());
  builder.setArray();
  Assert.assertEquals(MultiStringPropertyState.stringProperty("foo",Arrays.asList("bar")),builder.getPropertyState());
}
