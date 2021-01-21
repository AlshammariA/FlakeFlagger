@Test public void testAssignFromDates(){
  String date1="1970-01-01T00:00:00.000Z";
  String date2="1971-01-01T00:00:00.000Z";
  PropertyState source=MultiGenericPropertyState.dateProperty("foo",Arrays.asList(date1,date2));
  PropertyBuilder builder=PropertyBuilder.scalar(Type.DATE);
  builder.assignFrom(source);
  assertEquals(source,builder.getPropertyState());
}
