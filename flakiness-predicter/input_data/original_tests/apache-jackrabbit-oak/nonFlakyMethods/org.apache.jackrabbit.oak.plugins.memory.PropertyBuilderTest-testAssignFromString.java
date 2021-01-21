@Test public void testAssignFromString(){
  PropertyState source=StringPropertyState.stringProperty("foo","42");
  PropertyBuilder builder=PropertyBuilder.scalar(Type.LONG);
  builder.assignFrom(source);
  assertEquals(LongPropertyState.createLongProperty("foo",42L),builder.getPropertyState());
}
