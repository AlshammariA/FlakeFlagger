@Test public void testAssignFromLong(){
  PropertyState source=LongPropertyState.createLongProperty("foo",42L);
  PropertyBuilder builder=PropertyBuilder.scalar(Type.STRING);
  builder.assignFrom(source);
  assertEquals(StringPropertyState.stringProperty("foo","42"),builder.getPropertyState());
}
