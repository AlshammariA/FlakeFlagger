@Test public void testAssignFromDate(){
  String date="1970-01-01T00:00:00.000Z";
  PropertyState source=GenericPropertyState.dateProperty("foo",date);
  PropertyBuilder builder=PropertyBuilder.scalar(Type.DATE);
  builder.assignFrom(source);
  assertEquals(source,builder.getPropertyState());
}
